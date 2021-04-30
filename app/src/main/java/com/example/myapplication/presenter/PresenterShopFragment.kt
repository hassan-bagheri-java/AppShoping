package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataProductWebservice
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.Shop_Fragment
import com.example.myapplication.model.ModelShopFragment
import com.example.myapplication.net.CountryPreesenterListner

class PresenterShopFragment(
    private val view : Shop_Fragment,
    private val model : ModelShopFragment
) : BaseLifeCycle , CountryPreesenterListner<DataProductWebservice>{

    override fun oncreate() {
        getShopProducts()

    }


    private fun getShopProducts(){
        view.showProgress()
        model.getShopProducts(this, view.getEmail())

    }

    override fun onResponse(data: DataProductWebservice) {
        view.setUpRecycler(data.data)
        view.hideProgress()
    }

    override fun onFailure(error: String) {
        view.showToast(error)
        view.hideProgress()
    }

    override fun ondestroy() {}

}