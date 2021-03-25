package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelMainActivity
import com.example.myapplication.view.ViewMainActivity

class PresenterMainActivity(
    private val view :ViewMainActivity,
    private val model : ModelMainActivity
) : BaseLifeCycle {
    override fun oncreate() {
        setUpViewButom_nav()
        bottom_nav_setItemOnclick()
    }



    private fun setUpViewButom_nav(){
        view.setUpViewButom_nav(model.setUpViewButom_nav(), model.setmainfragment())
    }

    private fun bottom_nav_setItemOnclick (){
        view.bottom_nav_setItemOnclick(model.bottom_nav_setItemOnclick())
    }

    override fun ondestroy() {
    }




}