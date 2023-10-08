package com.example.ood_decorator.data

interface ICatsFactGateway {
    suspend fun getFact() : ApiResult<CatsFactResponseJson>
}