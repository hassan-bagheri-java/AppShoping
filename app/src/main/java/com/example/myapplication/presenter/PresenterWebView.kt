package com.example.myapplication.presenter

import com.example.myapplication.etc.BaseLifeCycle
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.view.ViewWebView

class PresenterWebView(
    private val view: ViewWebView,
    private val model: ModelWebView
) : BaseLifeCycle {
    override fun oncreate() {
        onclickback()
        init()
    }

    override fun onrefresh() {
        if (model.getNetworkState())
            view.loadUrl(model.getUrlAsIntent()!!)
        else
            view.showSnackBar(model.getTitleDialog())
    }

    private fun init() {
        if (model.getNetworkState())
            view.initWebView(model.getUrlAsIntent()!!)
        else
            view.showSnackBar(model.getTitleDialog())
    }

    private fun onclickback() {
        view.onclickback()
    }


    override fun ondestroy() {

    }

}