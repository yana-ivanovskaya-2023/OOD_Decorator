package com.example.ood_decorator.data


sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    sealed interface Error : ApiResult<Nothing> {
        data object NoInternetConnection : Error
        data object ServerNotResponding : Error
        data object Unknown : Error
    }
}