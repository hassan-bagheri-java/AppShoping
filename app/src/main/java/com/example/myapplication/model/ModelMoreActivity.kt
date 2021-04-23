package com.example.myapplication.model

import android.app.Activity
import android.util.Log
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.test.DataTest
import com.example.myapplication.view.CustomView.ProductView
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelMoreActivity (private val activity: Activity) : KoinComponent{

    private val apiService : ApiService by inject()

    fun setTitleText() = activity.intent.getStringExtra(ProductView.TITTLE_KEY)

    fun settypeproduct() = activity.intent.getSerializableExtra(ProductView.TYPE_KEY) as TypeGetProduct


    fun getDataNewRecycleProduct (mListner: CountryPreesenterListner<DataProductWebservice>){
        apiService.getAPi()
            .getDataNewProducts()
            .enqueue(object : Callback<DataProductWebservice> {
                override fun onFailure(call: Call<DataProductWebservice>, t: Throwable) {
                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                    Log.e("hassan", "خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                }

                override fun onResponse(
                    call: Call<DataProductWebservice>,
                    response: Response<DataProductWebservice>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListner.onResponse(data)
                    else
                        Log.e("Hassan", "null666 data")
                }

            })
    }

    fun getDataTakfifProducts (mListner: CountryPreesenterListner<DataProductWebservice>){
        apiService.getAPi()
            .getDataTakfifProducts()
            .enqueue(object : Callback<DataProductWebservice>{
                override fun onFailure(call: Call<DataProductWebservice>, t: Throwable) {
                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                    Log.e("hassan", "خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                }

                override fun onResponse(
                    call: Call<DataProductWebservice>,
                    response: Response<DataProductWebservice>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListner.onResponse(data)
                    else
                        Log.e("Hassan", "null data")
                }

            })
    }

    fun getDataPorForoshProducts (mListner: CountryPreesenterListner<DataProductWebservice>){
        apiService.getAPi()
            .getDataPorForoshProducts()
            .enqueue(object : Callback<DataProductWebservice>{
                override fun onFailure(call: Call<DataProductWebservice>, t: Throwable) {
                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                    Log.e("hassan", "خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                }

                override fun onResponse(
                    call: Call<DataProductWebservice>,
                    response: Response<DataProductWebservice>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListner.onResponse(data)
                    else
                        Log.e("Hassan", "null data")
                }

            })
    }

}