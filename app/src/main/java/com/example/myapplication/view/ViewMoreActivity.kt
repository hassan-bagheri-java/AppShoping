package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adpter.RecycleItemMoreAdapter
import com.example.myapplication.adpter.RecycleItemProductAdapter
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.utility.Utility
import kotlinx.android.synthetic.main.activity_more.view.*

@SuppressLint("ViewConstructor")
class ViewMoreActivity (contextInstance : Context, private val utility: Utility) : FrameLayout(contextInstance) {

    private val txtTitle : AppCompatTextView
    private val imgBack : AppCompatImageView
    private val recycleview :RecyclerView

    init {
        val mainView = inflate(context,R.layout.activity_more,this)


        txtTitle = mainView.more_title
        imgBack  = mainView.more_imgBack
        recycleview = mainView.more_recycleview

        recycleview.layoutManager = GridLayoutManager(context,2,LinearLayoutManager.VERTICAL , false)
    }

    fun setDataRecycler(data : List<DataProduct>){
        recycleview.adapter = RecycleItemMoreAdapter(context,data)
    }

    fun setTitleText(title:String){
        txtTitle.text = title
    }

    fun onClickHandler(){
        imgBack.setOnClickListener{ utility.onfinished()}
    }

}