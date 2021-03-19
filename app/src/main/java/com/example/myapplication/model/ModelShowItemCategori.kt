package com.example.myapplication.model

import android.app.Activity
import com.example.myapplication.net.ApiService
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModelShowItemCategori (private val activity: Activity) : KoinComponent{

    private val apiService: ApiService by inject ()
}