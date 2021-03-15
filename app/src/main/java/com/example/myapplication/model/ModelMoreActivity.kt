package com.example.myapplication.model

import android.app.Activity
import com.example.myapplication.test.DataTest
import com.example.myapplication.view.CustomView.ProductView

class ModelMoreActivity (private val activity: Activity){

    fun setDataRecycler() = DataTest.getDataRecycleProduct()

    fun setTitleText() = activity.intent.getStringExtra(ProductView.TITTLE_KEY)
}