    package com.example.myapplication.view.CustomView

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activity.MoreActivity
import com.example.myapplication.adpter.RecycleItemProductAdapter
import com.example.myapplication.dataClass.DataProduct
import kotlinx.android.synthetic.main.custom_view_product_view.view.*
import org.jetbrains.anko.startActivity

    class ProductView ( context : Context, attrs : AttributeSet) : FrameLayout(context,attrs ) {

    private val texall : AppCompatTextView
    private val texatitle : AppCompatTextView
    private val recycler : RecyclerView

    init {
        val view = inflate(context, R.layout.custom_view_product_view, this)
        texall = view.custom_view_more
        texatitle = view.custom_view_title
        recycler = view.recyclerView

        /**
         * set kar attrs
         */

        val typedArray = context.obtainStyledAttributes(attrs,R.styleable.ProductView)
        val text = typedArray.getString(R.styleable.ProductView_titleText)
        typedArray.recycle()

        texatitle.text = text

        recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
    }

    /**
     * inja mimyam maghdar dahi mikonimash
     */
    fun initRecycler(data: List<DataProduct>){
        recycler.adapter = RecycleItemProductAdapter(context, data)
        texall.setOnClickListener {context.startActivity<MoreActivity>()
        }
    }
}