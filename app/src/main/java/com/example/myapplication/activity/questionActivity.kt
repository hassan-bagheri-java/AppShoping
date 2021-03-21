package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewQuestionActivity

class questionActivity : AppCompatActivity() , Utility {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ViewQuestionActivity(this, this)
        setContentView(view)
    }

    override fun onfinished() {
        finish()
    }
}