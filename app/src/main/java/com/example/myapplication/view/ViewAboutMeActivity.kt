package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.example.myapplication.R
import com.example.myapplication.utility.Utility
import kotlinx.android.synthetic.main.activity_about_me.view.*

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

    fun onClickhandler() {
        imgBack.setOnClickListener { utility.onfinished() }
    }
}