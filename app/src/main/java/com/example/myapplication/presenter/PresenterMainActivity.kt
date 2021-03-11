package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelMainActivity
import com.example.myapplication.view.ViewMainActivity

class PresenterMainActivity(
    private val view :ViewMainActivity,
    private val model : ModelMainActivity
) : BaseLifeCycle {
    override fun oncreate() {
        showFragment_presenter()
    }

    override fun ondestroy() {
    }

    fun showFragment_presenter(){
        view.showFragment_view(model.showFragment_model())
    }


}