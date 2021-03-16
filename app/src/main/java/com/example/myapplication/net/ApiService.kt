package com.example.myapplication.net

import com.example.myapplication.dataClass.DataImgBannerUrl
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    interface DataApi {
        fun getImgeUrlForBanner() : Callback<DataImgBannerUrl>

    }

    fun getAPi() : DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("")
            .build()
            .create(DataApi::class.java)
}