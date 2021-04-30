package com.example.myapplication.model

import android.util.Log
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.net.ApiService
import com.example.myapplication.net.CountryPreesenterListner
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModelShopFragment : KoinComponent {

    private val apiService: ApiService by inject()

    fun getShopProducts(countryPreesenterListner: CountryPreesenterListner<DataProductWebservice>, email: String?) {

        Log.e("hassan", "${email}")
        val query = "call show_cartlist('${email}')"
        Log.e("hassan", "${query}")

        apiService.getAPi()
            .show_cartlist("select_custom", "${query}")
            .enqueue(object : Callback<DataProductWebservice> {

                override fun onFailure(call: Call<DataProductWebservice>, t: Throwable) {
                    countryPreesenterListner.onFailure("خطا در دریافت اطلاعات از سرور")

                }

                override fun onResponse(
                    call: Call<DataProductWebservice>,
                    response: Response<DataProductWebservice>
                ) {


                    Log.e("hassan", "${response}")
                    Log.e("hassan1", "${response.body()}")

                    val data = response.body()
                    if (data?.data  != null) {
                        countryPreesenterListner.onResponse(data)
                    } else
                        countryPreesenterListner.onFailure("سبد خرید شما خالی میباشد.")


                }

            })
    }
}