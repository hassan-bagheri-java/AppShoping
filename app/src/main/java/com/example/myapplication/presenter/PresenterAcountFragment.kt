package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.Acount_Fragment
import com.example.myapplication.model.ModelAcountFragment

class PresenterAcountFragment(
    private val view : Acount_Fragment,
    private val model : ModelAcountFragment
) : BaseLifeCycle{
    override fun oncreate() {

    }

    private fun setDataUser(){
        view.setDataUser(model.getNmame(),model.getEmail())
    }

    override fun ondestroy() {
    }
}