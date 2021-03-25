package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelDetailActivity
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.view.ViewDetailActivity

class PresenterDetailActivity (
    private val view :ViewDetailActivity,
    private val model : ModelDetailActivity
) : BaseLifeCycle , CountryPreesenterListner<DataProduct> {

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
        view.onclickHandler(model.getIdAsIntent())
    }

    private fun settitle(){
        view.settitle(model.gettitleAsIntent()!!)
    }

    override fun ondestroy() {

    }

    override fun onResponse(data: DataProduct) {
        view.showToast("111111")
        view.setUpViews(data)
        view.hideProgress()
    }

    override fun onFailure(error: String) {
        view.showToast("00000000")
        view.showSnackBar(error)
    }


}