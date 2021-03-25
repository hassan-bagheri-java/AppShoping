package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.fragment.LoginFragment
import com.example.myapplication.model.ModelLoginFragment

class PresenterLoginFragment(
    private val view: LoginFragment,
    private val model: ModelLoginFragment
) : BaseLifeCycle {


    override fun oncreate() {

    }

    override fun ondestroy() {
    }

}