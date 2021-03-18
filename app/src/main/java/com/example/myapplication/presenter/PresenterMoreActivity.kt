package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelMoreActivity
import com.example.myapplication.view.ViewMoreActivity

class PresenterMoreActivity(
    private val view: ViewMoreActivity,
    private val model: ModelMoreActivity
) : BaseLifeCycle{



    fun setTitleText() {
        view.setTitleText(model.setTitleText()?:"")
    }

    override fun oncreate() {
        onClickHandler()
        setDataRecycler()
        setTitleText()
    }

    override fun ondestroy() {
    }

    private fun onClickHandler(){
        view.onClickHandler()
    }

    private fun setDataRecycler(){
//        view.setDataRecycler(model.setDataRecycler())
        view.settypeproduct(model.settypeproduct())
    }
}