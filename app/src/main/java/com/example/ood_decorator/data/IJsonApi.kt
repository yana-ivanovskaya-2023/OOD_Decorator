package com.example.ood_decorator.data

interface IJsonApi {
    suspend fun <T> get(
        resultClass: Class<T>,
        path: String
    ): ApiResult<T>
}