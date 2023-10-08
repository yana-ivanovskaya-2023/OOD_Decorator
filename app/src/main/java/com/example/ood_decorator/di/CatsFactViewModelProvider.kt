package com.example.ood_decorator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ood_decorator.data.CatsFactGateway
import com.example.ood_decorator.domain.GetCatsFactUseCase
import com.example.ood_decorator.presentation.CatsFactViewModel

class CatsFactViewModelProvider : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatsFactViewModel(
            GetCatsFactUseCase(CatsFactGateway(AppDI.api))
        ) as T
    }

}