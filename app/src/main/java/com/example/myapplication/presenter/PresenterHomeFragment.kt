package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.model.ModelHomeFragment
import com.example.myapplication.net.CountryPreesenterListner

class PresenterHomeFragment(
    private val view: HomeFragment,
    private val model: ModelHomeFragment
) : BaseLifeCycle {


    override fun oncreate() {
    }


    override fun onresume() {
        setup()
        setUpBanners()
    }

    private fun setup() {
        view.getDataRecycleProduct_new(model.getDataRecycleProduct())
        view.getDataRecycleProduct__takhfif(model.getDataRecycleProduct())
        view.getDataRecycleProduct_porforosh(model.getDataRecycleProduct())

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

    override fun ondestroy() {}
}






