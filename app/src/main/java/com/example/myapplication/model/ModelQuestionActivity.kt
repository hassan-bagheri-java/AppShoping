package com.example.myapplication.model

import android.util.Log
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataQuestion
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelQuestionActivity : KoinComponent{

    private val apiService : ApiService by inject()

    fun getDataqestion (mListner: CountryPreesenterListner<List<DataQuestion>>){
        apiService.getAPi()
            .getDataqestion()
            .enqueue(object : Callback<List<DataQuestion>> {
                override fun onFailure(call: Call<List<DataQuestion>>, t: Throwable) {
                    Log.e("Hassan", "error in get Data :   ${t.message}")
                    mListner.onFailure("خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                    Log.e("hassan", "خظایی در دریافت اطلاعات  getDataNewRecycleProduct صورت گرفته است.")
                }

                override fun onResponse(
                    call: Call<List<DataQuestion>>,
                    response: Response<List<DataQuestion>>
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