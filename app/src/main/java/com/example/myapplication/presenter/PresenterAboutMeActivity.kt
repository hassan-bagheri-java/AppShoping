package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelAboutMeActivity
import com.example.myapplication.view.ViewAboutMeActivity

class PresenterAboutMeActivity (
    private val view : ViewAboutMeActivity,
    private val model : ModelAboutMeActivity
) : BaseLifeCycle {
    override fun oncreate() {
        onClickhandler()
    }


    private fun onClickhandler(){
        view.onClickhandler()
    }

    override fun ondestroy() {
    }
}

