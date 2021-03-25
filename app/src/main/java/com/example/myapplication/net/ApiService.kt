package com.example.myapplication.net

import com.example.myapplication.dataClass.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class ApiService {

    interface DataApi {
        @GET("webservice/banner.json")
        fun getImgeUrlForBanner(): Call<DataImgBannerUrl>

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
        fun getDataqestion(): Call<List<DataQuestion>>

        @GET("json/failurReport.php")
        fun sendFailureReport(
            @Query("subject") subject: String,
            @Query("text") text: String
        ): Call<Boolean>


        /**
         * baraye ezafe kardan y mahso b favarit az tarigh webservice
         */
        @GET("json/setproductporfroshinFavorite.php")
        fun setproductporfroshinFavorite(@Query("ic") id: Int): Call<Boolean>

        @GET("code/show.php")
        fun getProductById(@Query("id") id: Int): Call<DataProduct>


        @FormUrlEncoded
        @POST("code/login.php")
        fun userLogin(
            @Field("email") email: String,
            @Field("password") pass: String
        ): Call<DataLogin>

        @FormUrlEncoded
        @POST("code/register.php")
        fun userRegister(
            @Field("email") email: String,
            @Field("password") pass: String
        ): Call<DataLogin>

    }

    fun getAPi(): DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://hasanlo.ir/android/shop/")
            .build()
            .create(DataApi::class.java)
}