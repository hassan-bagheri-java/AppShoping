package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.presenter.PresenterWebView
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewWebView

class WebActivity : AppCompatActivity() , Utility{

    private lateinit var presenter : PresenterWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model = ModelWebView(this)
        val view = ViewWebView(this, this)
        setContentView(view)



        presenter = PresenterWebView(view, model)
        presenter.oncreate()
    }

    override fun onfinished() {
        finish()
    }

    override fun onRefresh() {
        presenter.onrefresh()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }
}