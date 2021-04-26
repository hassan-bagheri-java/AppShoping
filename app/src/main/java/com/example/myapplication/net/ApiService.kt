package com.example.myapplication.net

import com.example.myapplication.dataClass.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class ApiService {

    interface DataApi {
        @GET("webservice/banner.json")
        fun getImgeUrlForBanner(): Call<DataImgBannerUrl>

        @GET("webservice/categorie.json")
        fun setDataRecycleCategory(): Call<List<DataCategoriItem>>

        @GET("webservice/project/ws_tb.php?type=select&table=products&column=type&value=new_prodect")
        fun getDataNewProducts(): Call<DataProductWebservice>

        @GET("webservice/project/ws_tb.php?type=select&table=products&column=type&value=discount_products")
        fun getDataTakfifProducts(): Call<DataProductWebservice>

        @GET("webservice/project/ws_tb.php?type=select&table=products&column=type&value=top_selling_products")
        fun getDataPorForoshProducts(): Call<DataProductWebservice>

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

        @GET("webservice/project/ws_tb.php")
        fun getProductById(
            @Query("type") type: String,
            @Query("table") table: String,
            @Query("column") column: String,
            @Query("value") value: String?
        ): Call<DataProductWebservice>


        @FormUrlEncoded
        @POST("webservice/project/ws_tb.php")
        fun userLogin(
            @Field("type") type: String,
            @Field("query") query: String
        ): Call<DataLoginWebservice>

        @FormUrlEncoded
        @POST("webservice/project/ws_tb.php")
        fun userRegister(
            @Field("type") type: String,
            @Field("query") query: String
        ): Call<DataRegiser>

    }

    fun getAPi(): DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://hasanlo.ir/android/shop/")
            .build()
            .create(DataApi::class.java)
}