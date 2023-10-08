package com.example.ood_decorator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ood_decorator.di.AppDI
import com.example.ood_decorator.domain.GetCatsFactUseCase
import kotlinx.coroutines.launch

class CatsFactViewModel(
    private val getCatsFact: GetCatsFactUseCase
) : ViewModel() {

    init {
        println("init")
        viewModelScope.launch {
            val r = getCatsFact.invoke()
            println(r)
        }
    }

}