package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.model.ModelQuestionActivity
import com.example.myapplication.presenter.PresenterQuestionActivity
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewQuestionActivity
import org.koin.android.ext.android.inject

class questionActivity : AppCompatActivity() , Utility {

    private val model :ModelQuestionActivity by inject()
    private lateinit var presenter : PresenterQuestionActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ViewQuestionActivity(this, this)
        setContentView(view)

        presenter = PresenterQuestionActivity(view, model)
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