package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.LoginFragment
import com.example.myapplication.fragment.RegisterFragment
import com.example.myapplication.model.ModelLoginFragment
import com.example.myapplication.model.ModelRegisterFragment

class PresenterRegisterFragment(
    private val view: RegisterFragment,
    private val model: ModelRegisterFragment
) : BaseLifeCycle {


    override fun oncreate() {

    }

    private fun onclick() {
    }



    override fun ondestroy() {
    }

}