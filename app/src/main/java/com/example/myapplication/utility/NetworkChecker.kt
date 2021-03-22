package com.example.myapplication.utility

import android.content.Context
import android.net.ConnectivityManager

class NetworkChecker( private val context: Context) {

    fun networkState() : Boolean {
        val conManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val netInfo = conManager.activeNetworkInfo
        return (netInfo != null && netInfo.isConnected )

    }
}