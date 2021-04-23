package com.example.myapplication.model

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.myapplication.adpter.RecycleItemProductAdapter
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.test.DataTest
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelDetailActivity ( private val context: Activity) : KoinComponent {

    private val apiService : ApiService by inject()

    fun getIdAsIntent() = context.intent.getStringExtra(RecycleItemProductAdapter.KEY_ID)

    fun gettitleAsIntent() = context.intent.getStringExtra(RecycleItemProductAdapter.KEY_TITTLE)

    fun setDataRecycler() = DataTest.getDataComments()


    fun getProductById(countryPresenterListener: CountryPreesenterListner<DataProductWebservice>) {

        apiService
            .getAPi()
            .getProductById("select","products","id",getIdAsIntent())
            .enqueue(object : Callback<DataProductWebservice> {

                override fun onFailure(call: Call<DataProductWebservice>, t: Throwable) {

                    countryPresenterListener.onFailure("خط در دریافت طلاعات ازسرور")

                }

                override fun onResponse(call: Call<DataProductWebservice>, response: Response<DataProductWebservice>) {

                    val data = response.body()
                    if (data != null) {
                        Log.e("Hassan", "${response}")
                        countryPresenterListener.onResponse(data)
                    }
                    else
                        countryPresenterListener.onFailure("عدم وجود اطلاعات")

                }

            })

    }

}