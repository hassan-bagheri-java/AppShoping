package com.example.myapplication.model

import android.app.Activity
import android.util.Log
import com.example.myapplication.adpter.RecycleCategorieAdapter
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelShowItemCategori (private val activity: Activity) : KoinComponent{

    private val apiService: ApiService by inject ()

    fun getIdAsIntent() = activity.intent.getIntExtra(RecycleCategorieAdapter.KEY_ID, 0)

    fun getTitleAsIntent() = activity.intent.getStringExtra(RecycleCategorieAdapter.KEY_TITLE)


    /***
     * inja behtar bod tori pyade lonim k query zade basha
     */
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
                        Log.e("Hassan", "null55 data")
                }

            })
    }

    fun getDataNewRecycleProduct2 (mListner: CountryPreesenterListner<List<DataProduct>>){
        apiService.getAPi()
            .getDataNewProductCategoryId(getIdAsIntent())
            .enqueue(object : Callback<List<DataProduct>> {
                override fun onFailure(call: Call<List<DataProduct>>, t: Throwable) {
                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                    Log.e("hassan", "خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                }

                override fun onResponse(
                    call: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListner.onResponse(data)
                    else
                        Log.e("Hassan", "null data")
                }

            })
    }

    fun getDataPorforoshRecycleProduct (mListner: CountryPreesenterListner<List<DataProduct>>){
        apiService.getAPi()
            .getDataPorForoshProducts()
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
                        mListner.onResponse(data.data)
                    else
                        Log.e("Hassan", "null data")
                }

            })
    }




}