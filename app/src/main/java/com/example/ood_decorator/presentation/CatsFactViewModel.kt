package com.example.ood_decorator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ood_decorator.data.ApiResult
import com.example.ood_decorator.di.AppDI
import com.example.ood_decorator.domain.GetCatsFactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CatsFactViewModel(
    private val getCatsFact: GetCatsFactUseCase
) : ViewModel() {

    val state
        get() = mState.asStateFlow()

    private val mState = MutableStateFlow(CatsFactState.default())

    fun getNewFact() {
        viewModelScope.launch {
            mState.modify {
                copy(isLoading = true)
            }
            val fact = when (val result = getCatsFact.invoke()) {
                is ApiResult.Success -> result.data.value
                is ApiResult.Error -> "Some error happened..."
            }
            mState.modify {
                copy(isLoading = false, fact = fact)
            }
        }
    }

    private fun <T> MutableStateFlow<T>.modify(modifier: T.() -> T) {
        this.value = modifier(this.value)
    }

}