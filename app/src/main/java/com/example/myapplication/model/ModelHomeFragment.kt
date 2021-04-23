package com.example.myapplication.model

import android.util.Log
import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.test.DataTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelHomeFragment {

    private val apiService = ApiService()

//    inja data dasti gerfta shod
//    fun getDataNewProducts() = DataTest.getDataRecycleProduct()

    fun getDataNewRecycleProduct (mListner: CountryPreesenterListner<DataProductWebservice>){
        apiService.getAPi()
            .getDataNewProducts()
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
                        Log.e("Hassan", "null data777")
                        Log.e("Hassan", "${response}")

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


    fun setDataRecycleCategory(mListner: CountryPreesenterListner<List<DataCategoriItem>>) {

        apiService.getAPi()
            .setDataRecycleCategory()
            .enqueue(object : Callback<List<DataCategoriItem>> {
                override fun onFailure(call: Call<List<DataCategoriItem>>, t: Throwable) {
                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات  categori صورت گرفته است.")
                    Log.e("hassan", "get image failed")
                }
                override fun onResponse(
                    call: Call<List<DataCategoriItem>>,
                    response: Response<List<DataCategoriItem>>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListner.onResponse(data)
                    else
                        Log.e("Hassan", "null data")
                }
            })

    }


    fun setImageInBannerr(mListner: CountryPreesenterListner<DataImgBannerUrl>) {

        apiService.getAPi()
            .getImgeUrlForBanner()
            .enqueue(object : Callback<DataImgBannerUrl> {
                override fun onFailure(call: Call<DataImgBannerUrl>, t: Throwable) {

                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات banner صورت گرفته است.")
                    Log.e("hassan", "get image failed")

                }

                override fun onResponse(
                    call: Call<DataImgBannerUrl>,
                    response: Response<DataImgBannerUrl>
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