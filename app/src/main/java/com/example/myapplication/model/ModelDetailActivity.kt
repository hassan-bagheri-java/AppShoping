package com.example.myapplication.model

import android.app.Activity
import android.content.Context
import com.example.myapplication.adpter.RecycleItemProductAdapter
import com.example.myapplication.dataClass.DataProduct
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

    fun getIdAsIntent() = context.intent.getIntExtra(RecycleItemProductAdapter.KEY_ID, 0)

    fun gettitleAsIntent() = context.intent.getStringExtra(RecycleItemProductAdapter.KEY_TITTLE)

    fun setDataRecycler() = DataTest.getDataComments()

    fun  getDataProduct() = DataTest.getDataProduct()

    fun getProductById(countryPresenterListener: CountryPreesenterListner<DataProduct>) {

        apiService
            .getAPi()
            .getProductById(getIdAsIntent())
            .enqueue(object : Callback<DataProduct> {

                override fun onFailure(call: Call<DataProduct>, t: Throwable) {

                    countryPresenterListener.onFailure("خط در دریافت طلاعات ازسرور")

                }

                override fun onResponse(call: Call<DataProduct>, response: Response<DataProduct>) {

                    val data = response.body()
                    if (data != null)
                        countryPresenterListener.onResponse(data)
                    else
                        countryPresenterListener.onFailure("عدم وجود اطلاعات")

                }

            })

    }

}