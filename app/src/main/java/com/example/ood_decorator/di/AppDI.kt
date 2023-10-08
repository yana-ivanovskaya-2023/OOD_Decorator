package com.example.ood_decorator.di

import android.content.Context
import com.example.ood_decorator.data.JsonApi
import com.example.ood_decorator.data.NetworkCheckerApiDecorator
import com.example.ood_decorator.data.raw.LoggerRawApiDecorator
import com.example.ood_decorator.data.raw.RawApi
import com.google.gson.Gson
import okhttp3.OkHttpClient

object AppDI {

    val api by lazy {
        NetworkCheckerApiDecorator(
            mApplicationContext,
            JsonApi(mRawApi, Gson())
        )
    }

    private val mOkHttpClient = OkHttpClient()
    private val mRawApi by lazy { LoggerRawApiDecorator(RawApi(mOkHttpClient)) }

    private lateinit var mApplicationContext: Context

    fun init(context: Context) {
        mApplicationContext = context
    }

}