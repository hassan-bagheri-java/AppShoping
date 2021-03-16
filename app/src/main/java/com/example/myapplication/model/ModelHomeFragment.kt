package com.example.myapplication.model

import android.util.Log
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.test.DataTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelHomeFragment {

    private val apiService = ApiService()

    fun getDataRecycleProduct() = DataTest.getDataRecycleProduct()
    fun setDataRecycleCategory() = DataTest.setDataRecycleCategory()
    fun setImageInBannerr(mListner: CountryPreesenterListner<DataImgBannerUrl>) {

        apiService.getAPi()
            .getImgeUrlForBanner()
            .enqueue(object : Callback<DataImgBannerUrl> {
                override fun onFailure(call: Call<DataImgBannerUrl>, t: Throwable) {

                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات صورت گرفته است.")
                    Log.e("hassan" ,"get image failed")

                }

                override fun onResponse(
                    call: Call<DataImgBannerUrl>,
                    response: Response<DataImgBannerUrl>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListner.onResponse(data)
                    else
                        Log.e("Hassan","null data")

                }

            })
    }
}