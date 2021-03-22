package com.example.myapplication.model

import android.app.Activity
import android.content.Context
import com.example.myapplication.utility.NetworkChecker

class ModelWebView (private val context: Activity){

    companion object {
        const val KEY_URL = "url"
    }

    fun getUrlAsIntent() = context.intent.getStringExtra(KEY_URL)

    fun getNetworkState () = NetworkChecker(context).networkState()

    fun getTitleDialog() = "Not Connection !! "
}