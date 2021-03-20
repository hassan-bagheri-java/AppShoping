package com.example.myapplication.view

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.CustomView.ProductView
import kotlinx.android.synthetic.main.activity_show_item_categori.view.*
import org.jetbrains.anko.toast

class ViewShowItemCategori (contextinstace: Context , private val utility: Utility) : FrameLayout(contextinstace) {

    private val root : ConstraintLayout
    private val txtTitle : AppCompatTextView
    private val imgbanner : AppCompatImageView
    private val newproduct : ProductView
    private val imgback : AppCompatImageView
    private val progress : ProgressBar
    private val porforosh : ProductView


    init {
        val mainview =  inflate(context, R.layout.activity_show_item_categori, this)
        root  = show_item_categori_root
        txtTitle = show_item_categori_title
        imgback = mshow_item_categori_imgBack
        imgbanner = show_item_categori_banner
        newproduct = show_item_categori_productnew
        progress = show_item_categori_progress
        porforosh = show_item_categori_porfrosh
    }

    fun setTitle( title : String){
        txtTitle.text = title
    }

    fun SetDataNewProduct(data : List<DataProduct>){
        porforosh.initRecycler(data,TypeGetProduct.NEW_PRODUCT)
    }

    fun setDataPorforoshProduct(data : List<DataProduct>){
        newproduct.initRecycler(data, TypeGetProduct.PORFOROSH_PRODUCT)
        hideProgress()
    }

    fun onclickback(){
        imgback.setOnClickListener { utility.onfinished() }
    }

    fun showProgress(){
        show_item_categori_progress.visibility = View.INVISIBLE
        show_item_categori_root.visibility = View.INVISIBLE
    }

    fun hideProgress() {
        show_item_categori_progress.visibility = View.VISIBLE
        show_item_categori_root.visibility = View.VISIBLE
    }

    fun showToas(text: String) {
        context.toast(text)


    }
}