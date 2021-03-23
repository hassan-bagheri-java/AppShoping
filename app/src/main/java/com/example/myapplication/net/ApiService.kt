package com.example.myapplication.net

import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataQuestion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ApiService {

    interface DataApi {
        @GET("webservice/banner.json")
        fun getImgeUrlForBanner() : Call<DataImgBannerUrl>

        @GET("webservice/categorie.json")
        fun setDataRecycleCategory(): Call<List<DataCategoriItem>>

        @GET("webservice/new_products.json")
        fun getDataNewProducts(): Call<List<DataProduct>>

        @GET("webservice/new_products.json")
        fun getDataTakfifProducts(): Call<List<DataProduct>>

        @GET("webservice/new_products.json")
        fun getDataPorForoshProducts(): Call<List<DataProduct>>

        @GET("webservice/getDataNewProductCategoryId.json")
        fun getDataNewProductCategoryId(@Query("id") id: Int): Call<List<DataProduct>>

        @GET("webservice/getDataPorforoshProductCategoryId.json")
        fun getDataPorforoshProductCategoryId(@Query("id") id: Int): Call<List<DataProduct>>

        @GET("webservice/DataQuestion.json")
        fun getDataqestion() : Call<List<DataQuestion>>

        @GET("json/failurReport.php")
        fun sendFailureReport(
            @Query("subject") subject : String,
            @Query("text") text : String
        ) : Call<Boolean>
    }

    fun getAPi() : DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://hasanlo.ir/android/shop/")
            .build()
            .create(DataApi::class.java)
}