package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelQuestionActivity
import com.example.myapplication.view.ViewQuestionActivity

class PresenterQuestionActivity(
    private val view : ViewQuestionActivity,
    private val model : ModelQuestionActivity
) : BaseLifeCycle{
    override fun oncreate() {

    }

    private fun onclickBack(){
        view.onclickBack()
    }

    override fun ondestroy() {

    }
}