package com.example.ood_decorator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.ood_decorator.data.CatsFactGateway
import com.example.ood_decorator.di.AppDI
import com.example.ood_decorator.di.CatsFactViewModelProvider
import com.example.ood_decorator.domain.GetCatsFactUseCase
import com.example.ood_decorator.presentation.CatsFactViewModel
import com.yana.ood_strategy.R


class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModels<CatsFactViewModel> {
        CatsFactViewModelProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel
    }
}