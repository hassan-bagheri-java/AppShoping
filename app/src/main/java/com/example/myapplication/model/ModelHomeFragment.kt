package com.example.myapplication.model

import android.util.Log
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.test.DataTest
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ModelHomeFragment {

    private val apiService = ApiService()

    fun getDataRecycleProduct() = DataTest.getDataRecycleProduct()
    fun setDataRecycleCategory() = DataTest.setDataRecycleCategory()
    fun setImageInBannerr(mListner: CountryPreesenterListner<DataImgBannerUrl>) {
        apiService.getAPi()
            .getImgeUrlForBanner()
            .equals(object : retrofit2.Callback<DataImgBannerUrl> {
                override fun onFailure(call: Call<DataImgBannerUrl>, t: Throwable) {

                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات صورت گرفته است.")

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