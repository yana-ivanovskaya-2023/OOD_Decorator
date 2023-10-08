package com.example.ood_decorator.data.raw

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Response


class LoggerRawApiDecorator(
    private val rawApi: IRawApi
) : IRawApi {

    override suspend fun get(path: String): Response? {
        val time1 = System.currentTimeMillis()
        val response = rawApi.get(path)
        val time2 = System.currentTimeMillis() - time1
        println("GET: $path\nStatus: ${response?.code}\nTime: $time2 ms\n")
        return response
    }

}