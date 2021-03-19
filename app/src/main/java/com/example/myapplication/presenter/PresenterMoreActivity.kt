package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelMoreActivity
import com.example.myapplication.net.CountryPreesenterListner
import com.example.myapplication.view.ViewMoreActivity

class PresenterMoreActivity(
    private val view: ViewMoreActivity,
    private val model: ModelMoreActivity
) : BaseLifeCycle {


    fun setTitleText() {
        view.setTitleText(model.setTitleText() ?: "")
    }

    override fun oncreate() {
        onClickHandler()
        setDataRecycler()
        setTitleText()
    }

    override fun ondestroy() {
    }

    private fun onClickHandler() {
        view.onClickHandler()
    }

    private fun setDataRecycler() {
//        view.setDataRecycler(model.setDataRecycler())
        view.settypeproduct(model.settypeproduct())

        when (model.settypeproduct()) {
            TypeGetProduct.NEW_PRODUCT -> {
                model.getDataNewRecycleProduct(object :
                    CountryPreesenterListner<List<DataProduct>> {
                    override fun onResponse(data: List<DataProduct>) {
                        view.getDataRecycleProductMoreActivity(data)
                    }

                    override fun onFailure(error: String) {
                        view.showToast(error)
                    }

                })
            }

            TypeGetProduct.TAKHFIF_PRODUCT -> {
                model.getDataTakfifProducts(object :
                    CountryPreesenterListner<List<DataProduct>> {
                    override fun onResponse(data: List<DataProduct>) {
                        view.getDataRecycleProductMoreActivity(data)
                    }

                    override fun onFailure(error: String) {
                        view.showToast(error)
                    }

                })
            }
            TypeGetProduct.PORFOROSH_PRODUCT -> {
                model.getDataPorForoshProducts(object :
                    CountryPreesenterListner<List<DataProduct>> {
                    override fun onResponse(data: List<DataProduct>) {
                        view.getDataRecycleProductMoreActivity(data)
                    }

                    override fun onFailure(error: String) {
                        view.showToast(error)
                    }

                })

            }

        }
    }
}
