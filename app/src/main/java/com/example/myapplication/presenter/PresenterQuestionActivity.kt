package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataQuestion
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelQuestionActivity
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.view.ViewQuestionActivity

class PresenterQuestionActivity(
    private val view : ViewQuestionActivity,
    private val model : ModelQuestionActivity
) : BaseLifeCycle{
    override fun oncreate() {
        onclickBack()
        getDataqestion()
    }

    private fun getDataqestion(){

        model.getDataqestion(object : CountryPreesenterListner<List<DataQuestion>>{
            override fun onResponse(data: List<DataQuestion>) {
                view.initRecycler(data)
                view.hideProgress()
            }

            override fun onFailure(error: String) {
                view.showToast(error)
                view.hideProgress()
            }

        })
    }

    private fun onclickBack(){
        view.onclickBack()
    }

    override fun ondestroy() {

    }
}