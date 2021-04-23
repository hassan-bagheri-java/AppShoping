package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelShowItemCategori
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.view.ViewShowItemCategori

class presenterShowItemCategori (
    private val view : ViewShowItemCategori,
    private val model : ModelShowItemCategori
) : BaseLifeCycle{


    override fun oncreate() {
        showprogress()
        setdataRecyclers()
        setTitle()
        onclickback()
    }

    private fun setTitle(){
        view.setTitle(model.getTitleAsIntent() ?: "")
    }

    private fun setdataRecyclers() {

        model.getDataNewRecycleProduct(object :CountryPreesenterListner<DataProductWebservice>{
            override fun onResponse(data: DataProductWebservice) {
                view.SetDataNewProduct(data.data)
            }

            override fun onFailure(error: String) {
                view.showToas(error)
            }

        })

        model.getDataPorforoshRecycleProduct(object :CountryPreesenterListner<List<DataProduct>>{
            override fun onResponse(data: List<DataProduct>) {
                view.setDataPorforoshProduct(data)
            }

            override fun onFailure(error: String) {
                view.showToas(error)
            }

        })


    }

    private fun onclickback(){
        view.onclickback()
    }

    private fun showprogress(){
        view.showProgress()
    }

    override fun ondestroy() {

    }
}