package com.example.ood_decorator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.ood_decorator.data.CatsFactGateway
import com.example.ood_decorator.di.AppDI
import com.example.ood_decorator.di.CatsFactViewModelProvider
import com.example.ood_decorator.domain.GetCatsFactUseCase
import com.example.ood_decorator.presentation.CatsFactViewModel
import com.yana.ood_strategy.R
import com.yana.ood_strategy.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModels<CatsFactViewModel> {
        CatsFactViewModelProvider()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            mViewModel.getNewFact()
        }

        mViewModel.state.onEach {
            binding.factText.text = it.fact
            binding.factText.isVisible = !it.isLoading
            binding.progress.isVisible = it.isLoading
        }.launchIn(lifecycleScope)
    }

}