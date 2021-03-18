package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.model.ModelHomeFragment
import com.example.myapplication.net.CountryPreesenterListner

class PresenterHomeFragment(
    private val view: HomeFragment,
    private val model: ModelHomeFragment
) : BaseLifeCycle {


    override fun oncreate() {
        setDataRecyclers()
        setUpBanners()
    }


    override fun onresume() {

    }


    private fun setUpBanners() {
        model.setImageInBannerr(object : CountryPreesenterListner<DataImgBannerUrl> {
            override fun onResponse(data: DataImgBannerUrl) {
                view.setImageInBannerr(data)

            }

            override fun onFailure(error: String) {
                view.showToast(error)
            }

        })

        model.setDataRecycleCategory(object : CountryPreesenterListner<List<DataCategoriItem>> {
            override fun onResponse(data: List<DataCategoriItem>) {
                view.setDataRecycleCategory(data)
            }

            override fun onFailure(error: String) {
                view.showToast(error)
            }


        })






    }


    private fun setDataRecyclers(){
        model.getDataNewRecycleProduct(object : CountryPreesenterListner<List<DataProduct>>{
            override fun onResponse(data: List<DataProduct>) {
                view.getDataRecycleProduct_new(data)
            }

            override fun onFailure(error: String) {
                view.showToast(error)
            }

        })


        model.getDataTakfifProducts(object : CountryPreesenterListner<List<DataProduct>>{
            override fun onResponse(data: List<DataProduct>) {
                view.getDataRecycleProduct__takhfif(data)
            }

            override fun onFailure(error: String) {
                view.showToast(error)
            }

        })

        model.getDataPorForoshProducts(object : CountryPreesenterListner<List<DataProduct>>{
            override fun onResponse(data: List<DataProduct>) {
                view.getDataRecycleProduct_porforosh(data)
            }

            override fun onFailure(error: String) {
                view.showToast(error)
            }

        })
    }



    override fun ondestroy() {}
}






