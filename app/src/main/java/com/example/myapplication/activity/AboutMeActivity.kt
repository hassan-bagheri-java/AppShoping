package com.example.myapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.model.ModelAboutMeActivity
import com.example.myapplication.presenter.PresenterAboutMeActivity
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewAboutMeActivity
import org.koin.android.ext.android.inject

class AboutMeActivity : AppCompatActivity() , Utility{

    private lateinit var presenter : PresenterAboutMeActivity
    private val model : ModelAboutMeActivity by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view  = ViewAboutMeActivity(this,this)

        setContentView(view)
        presenter = PresenterAboutMeActivity(view, model)
        presenter.oncreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }

    override fun onfinished() { finish()    }


}
