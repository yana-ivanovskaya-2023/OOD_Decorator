package com.example.ood_decorator.ui

import android.app.Application
import com.example.ood_decorator.di.AppDI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppDI.init(applicationContext)
    }

}