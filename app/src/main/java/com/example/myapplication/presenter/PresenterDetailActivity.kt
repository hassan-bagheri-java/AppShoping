package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelDetailActivity
import com.example.myapplication.view.ViewDetailActivity

class PresenterDetailActivity (
    private val view :ViewDetailActivity,
    private val model : ModelDetailActivity
) : BaseLifeCycle{

    override fun oncreate() {
        onclickHandler()
        settitle()
        setDataRecycler()
    }

    fun setDataRecycler(){
        view.setDataRecycler(model.setDataRecycler())
    }

    private fun onclickHandler (){
        view.onclickHandler()
    }

    private fun settitle(){
        view.settitle(model.gettitleAsIntent()!!)
    }

    override fun ondestroy() {

    }


}