package com.example.myapplication.model

import android.app.Activity
import android.content.Context
import com.example.myapplication.adpter.RecycleItemProductAdapter
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.test.DataTest

class ModelDetailActivity ( private val context: Activity) {

    fun getTypeAsIntent(){
        context.intent.getSerializableExtra(RecycleItemProductAdapter.KEY_TYPE) as TypeGetProduct
    }

    fun getIdAsIntent() = context.intent.getIntExtra(RecycleItemProductAdapter.KEY_ID, 0)

    fun gettitleAsIntent() = context.intent.getStringExtra(RecycleItemProductAdapter.KEY_TITTLE)

    fun setDataRecycler() = DataTest.getDataComments()
    fun setDataRecycler() = DataTest.getDataComments()
}