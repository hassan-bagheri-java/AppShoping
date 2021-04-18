package com.example.myapplication.androidWrapper

import android.app.Application
import com.example.myapplication.di.*
import org.koin.android.ext.android.startKoin
import org.koin.standalone.StandAloneContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext,
            listOf(
                fragmentModules,
                modelModules,
                apiModules,
                presenterModules,
                fragment
            ))
    }
}