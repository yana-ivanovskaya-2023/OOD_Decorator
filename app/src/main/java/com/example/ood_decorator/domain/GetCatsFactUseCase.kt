package com.example.ood_decorator.domain

import com.example.ood_decorator.data.ApiResult
import com.example.ood_decorator.data.ICatsFactGateway

class GetCatsFactUseCase(
    private val gateway: ICatsFactGateway
) {

    suspend operator fun invoke(): ApiResult<CatsFact> {
        return when (val result = gateway.getFact()) {
            is ApiResult.Success -> ApiResult.Success(CatsFact(result.data.fact))
            is ApiResult.Error -> result
        }
    }

}



