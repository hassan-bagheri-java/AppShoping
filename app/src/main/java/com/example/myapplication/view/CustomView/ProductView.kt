package com.example.myapplication.view.CustomView

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.custom_view_product_view.view.*

class ProductView ( context : Context, attrs : AttributeSet) : FrameLayout(context,attrs ) {

    private val texall : AppCompatTextView
    private val texatitle : AppCompatTextView
    private val recycker : RecyclerView

    init {
        val view = inflate(context, R.layout.custom_view_product_view, this)
        texall = view.custom_view_more
        texatitle = view.custom_view_title
        recycker = view.recyclerView

        /**
         * set kar attrs
         */

        val typedArray = context.obtainStyledAttributes(attrs,R.styleable.ProductView)
        val text = typedArray.getString(R.styleable.ProductView_titleText)
        typedArray.recycle()

        texall.text = text

        recycker.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
    }
}