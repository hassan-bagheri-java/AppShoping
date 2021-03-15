package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.model.ModelMoreActivity
import com.example.myapplication.presenter.PresenterMoreActivity
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewMoreActivity
import org.koin.android.ext.android.inject

class MoreActivity : AppCompatActivity() , Utility {

    private lateinit var presenter: PresenterMoreActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model = ModelMoreActivity(this)

        val view = ViewMoreActivity(this,this)
        setContentView(view)

        presenter= PresenterMoreActivity(view,model)

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