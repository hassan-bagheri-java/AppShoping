package com.example.myapplication.model

import com.example.myapplication.net.ApiService
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModelRegisterFragment : KoinComponent {

    private val apiService: ApiService by inject()

    fun getObjectApiService() = apiService

}