package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.model.ModelDetailActivity
import com.example.myapplication.presenter.PresenterDetailActivity
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewDetailActivity

class DetailActivity : AppCompatActivity() , Utility {

    private lateinit var presenter : PresenterDetailActivity

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        val view = ViewDetailActivity (this , this)
        val model = ModelDetailActivity(this)


        setContentView(view)
        presenter = PresenterDetailActivity(view, model)
        presenter.oncreate()

    }

    override fun onfinished() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }
}