package com.example.ood_decorator.presentation


data class CatsFactState(
    val fact: String,
    val isLoading: Boolean
) {
    companion object {
        fun default() = CatsFactState(
            fact = "",
            isLoading = false
        )
    }
}