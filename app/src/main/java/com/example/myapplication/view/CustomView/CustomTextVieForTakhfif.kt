package com.example.myapplication.view.CustomView

import android.annotation.SuppressLint
import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R

@SuppressLint("CustomViewStyleable")
class CustomTextVieForTakhfif(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

//    init {
//
//
//        drawLine()
//
//        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
//        val size = typedArray.getFloat(R.styleable.CustomTextView_size,12f)
//        typedArray.recycle()
//
//
//        textSize = size
////        textSize = 20f
//    }

    init {

        drawLine()

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        val size = typedArray.getFloat(R.styleable.CustomTextView_size, 12f)
        typedArray.recycle()

        textSize = size

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