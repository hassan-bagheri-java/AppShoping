package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelLoginActivity
import com.example.myapplication.view.ViewLoginActivity

class PresenterLoginActivity(
    private val view: ViewLoginActivity,
    private val model: ModelLoginActivity
) : BaseLifeCycle {


    override fun oncreate() {
        checkNet()
        setUpTabLayout()
    }

    private fun checkNet() {
        view.checkInternet(model.checkNetInfo())
    }

    private fun setUpTabLayout() {
        view.setUpTabLayout(model.getAdapter(), model.getObjectLogin(), model.getObjectRegister())
    }


    override fun ondestroy() {
    }

}