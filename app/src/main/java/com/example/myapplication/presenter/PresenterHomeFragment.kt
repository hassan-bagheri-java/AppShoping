package com.example.myapplication.presenter

import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.model.ModelHomeFragment
import com.example.myapplication.net.CountryPreesenterListner

class PresenterHomeFragment(
    private val view: HomeFragment,
    private val model: ModelHomeFragment
) : BaseLifeCycle , CountryPreesenterListner<DataImgBannerUrl>{


    override fun oncreate() {
        setup()
    }

    private fun setup(){
        view.getDataRecycleProduct_new(model.getDataRecycleProduct())
        view.getDataRecycleProduct__takhfif(model.getDataRecycleProduct())
        view.getDataRecycleProduct_porforosh(model.getDataRecycleProduct())
        view.setDataRecycleCategory(model.setDataRecycleCategory())
    }

    override fun ondestroy() {
    }

    override fun onResponse(data: DataImgBannerUrl) {
        view.setImageInBannerr(data)
    }

    override fun onFailure(error: String) {
        view.showToast(error)
    }
}