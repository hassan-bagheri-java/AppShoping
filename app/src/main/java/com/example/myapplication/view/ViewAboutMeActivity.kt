package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.webkit.WebView
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.example.myapplication.R
import com.example.myapplication.activity.WebActivity
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.utility.Utility
import kotlinx.android.synthetic.main.activity_about_me.view.*
import org.jetbrains.anko.startActivity
import java.lang.Exception

@SuppressLint("ViewConstructor")
class ViewAboutMeActivity(
    contextInstance: Context
    , private val utility: Utility
) : FrameLayout(contextInstance) {
    private val imgBack: AppCompatImageView
    private val imgTelegram: AppCompatImageView
    private val imgInstagram: AppCompatImageView
    private val imgSite: AppCompatImageView

    init {
        val mainView = inflate(context, R.layout.activity_about_me, this)

        imgBack = mainView.img_back_about_me_activity
        imgTelegram = mainView.img_telegram_about_me_activity
        imgInstagram = mainView.img_instagram_about_me_activity
        imgSite = mainView.img_site_about_me_activity
    }

    fun onClickhandler(urlsite : String , urlTelgram : String, urlinstagram : String) {
        imgBack.setOnClickListener { utility.onfinished() }

        imgTelegram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlTelgram ))
            intent.setPackage("org.telegram.messenger")

            try {
                context.startActivity(intent)
            }catch (e : Exception){
                context.startActivity<WebActivity>(ModelWebView.KEY_URL to urlTelgram)
            }
        }

        imgInstagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlinstagram))
            intent.setPackage("com.instagram.android")
            try {
                context.startActivity(intent)
            }catch (e : Exception){
                context.startActivity<WebActivity>(ModelWebView.KEY_URL to urlinstagram )
            }
        }

        imgSite.setOnClickListener { context?.startActivity<WebActivity>(ModelWebView.KEY_URL to urlsite) }
    }
}