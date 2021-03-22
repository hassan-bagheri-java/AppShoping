package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.view.ViewWebView

class PresenterWebView (private val view : ViewWebView,
private val model : ModelWebView) : BaseLifeCycle {
    override fun oncreate() {

    }

    override fun ondestroy() {

    }

}