package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelDetailActivity
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.view.ViewDetailActivity

class PresenterDetailActivity (
    private val view :ViewDetailActivity,
    private val model : ModelDetailActivity
) : BaseLifeCycle , CountryPreesenterListner<DataProductWebservice> {

    override fun oncreate() {
        onclickHandler()
        settitle()
        setDataRecycler()
        setDataProduct()

    }

    override fun onrefresh() {
        setDataRecycler()
        setDataProduct()
    }

    fun setDataRecycler(){
        view.setDataRecycler(model.setDataRecycler())
    }

    private fun setDataProduct() {
        model.getProductById(this)
    }




    private fun onclickHandler (){
        view.onclickHandler(model.getIdAsIntent().toString())
    }

    private fun settitle(){
        view.settitle(model.gettitleAsIntent()!!)
    }

    override fun ondestroy() {

    }

    override fun onResponse(data: DataProductWebservice) {
        view.showToast(data.data[0].id)
        view.setUpViews(data.data[0])
        view.hideProgress()
    }

    override fun onFailure(error: String) {
        view.showToast("00000000")
        view.showSnackBar(error)
    }


}