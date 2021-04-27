package com.example.myapplication.model

import android.content.Context

class ModelAcountFragment(private val context: Context? ) {

    fun getNmame() =
        context?.getSharedPreferences("pref", Context.MODE_PRIVATE)?.getString("name", "") ?: ""

    fun getEmail() =
        context?.getSharedPreferences("pref", Context.MODE_PRIVATE)?.getString("email", "") ?: ""

}