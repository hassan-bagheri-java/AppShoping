package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.Shop_Fragment
import com.example.myapplication.model.ModelShopFragment

class PresenterShopFragment(
    private val view : Shop_Fragment,
    private val model : ModelShopFragment
) : BaseLifeCycle{
    override fun oncreate() {

    }

    override fun ondestroy() {

    }
}