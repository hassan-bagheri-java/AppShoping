package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.utility.Utility
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_web.view.*

@SuppressLint("ViewConstructor")
class ViewWebView(contextInstance : Context,
                  private val utility : Utility) : FrameLayout(contextInstance) {

    private val webView : WebView
    private val imgback : AppCompatImageView
    private val root : ConstraintLayout

    init {
        val mainView  = inflate(context, R.layout.activity_web, this)

        webView = mainView.webview_web
        imgback = mainView.webview_imgBack
        root = mainView.webview_root
    }

    fun onclickback() {
        imgback.setOnClickListener { utility.onfinished() }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(url : String){

        webView.settings.javaScriptEnabled = true
        webView.settings.builtInZoomControls = true
        webView.settings.textZoom = 100
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }

    fun showSnackBar(title: String) {

        val snack = Snackbar.make(
            root,
            title,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.setActionTextColor(Color.CYAN)
        snack.setAction("تلاش مجدد"){ snack.dismiss() }
        snack.show()

    }

}