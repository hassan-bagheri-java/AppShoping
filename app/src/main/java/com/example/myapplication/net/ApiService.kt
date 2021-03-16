package com.example.myapplication.net

import com.example.myapplication.dataClass.DataImgBannerUrl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApiService {

    interface DataApi {
        @GET("banner.json")
        fun getImgeUrlForBanner() : Call<DataImgBannerUrl>

    }

    fun getAPi() : DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://hasanlo.ir/android/shop/webservice/")
            .build()
            .create(DataApi::class.java)
}