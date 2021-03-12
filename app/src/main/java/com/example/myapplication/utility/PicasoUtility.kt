package com.example.myapplication.utility

import android.widget.ImageView
import com.squareup.picasso.Picasso
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PicasoUtility : KoinComponent {

    private val picaso: Picasso by inject()

    fun setimage(address: String, img: ImageView) {
        picaso.load(address).fit()
            .into(img)
    }
}