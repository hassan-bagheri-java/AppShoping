package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebView
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.myapplication.R
import com.example.myapplication.utility.Utility
import kotlinx.android.synthetic.main.activity_web.view.*

@SuppressLint("ViewConstructor")
class ViewWebView(contextInstance : Context,
                  private val utility : Utility) : FrameLayout(contextInstance) {

    private val webView : WebView
    private val imgback : AppCompatImageView

    init {
        val mainView  = inflate(context, R.layout.activity_web, this)

        webView = mainView.webview_web
        imgback = mainView.webview_imgBack
    }

    fun onclickback() {
        imgback.setOnClickListener { utility.onfinished() }
    }

    fun initWebView(url : String){

    }

}