package com.example.myapplication.view.CustomView

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.appcompat.widget.AppCompatTextView

class CustomTextVieForTakhfif(context: Context) : AppCompatTextView(context) {

    init {
        drawLine()
        textSize = 12f
    }

    fun setCustomText( value : String){
        text = value
        drawLine()
    }

    private fun drawLine() {
        val span = SpannableString(text)
        span.setSpan(StrikethroughSpan(), 0, text.length, Spanned.SPAN_MARK_MARK)
        text = span
    }
}