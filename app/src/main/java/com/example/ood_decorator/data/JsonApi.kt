package com.example.ood_decorator.data

import com.example.ood_decorator.data.raw.IRawApi
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

class JsonApi(
    private val rawApi: IRawApi,
    private val jsonParser: Gson
) : IJsonApi {

    override suspend fun <T> get(
        resultClass: Class<T>,
        path: String
    ): ApiResult<T> {
        val response = rawApi.get(path)
        val body = response?.body?.string().orEmpty()

        return when {
            response?.code?.rem(100) == 5 ->
                ApiResult.Error.ServerNotResponding

            else -> try {
                ApiResult.Success(jsonParser.fromJson(body, resultClass))
            } catch (ex: JsonSyntaxException) {
                return ApiResult.Error.Unknown
            }
        }
    }

}