package com.example.ood_decorator.data

class CatsFactGateway(
    private val api: IJsonApi
) : ICatsFactGateway {

    override suspend fun getFact(): ApiResult<CatsFactResponseJson> {
        return api.get(
            CatsFactResponseJson::class.java,
            "https://catfact.ninja/fact"
        )
    }

}