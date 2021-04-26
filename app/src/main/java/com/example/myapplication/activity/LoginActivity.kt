package com.example.myapplication.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.model.ModelLoginActivity
import com.example.myapplication.presenter.PresenterLoginActivity
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewLoginActivity
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), Utility {

    private lateinit var presenter: PresenterLoginActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkLogin()

        val view = ViewLoginActivity(this, this)
        val model = ModelLoginActivity(this)

        setContentView(view)

        presenter = PresenterLoginActivity(view, model)
        presenter.oncreate()

    }

    override fun onRefresh() {
        presenter.oncreate()
    }

    private fun checkLogin() {
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)

        if (pref.getBoolean("login", false))
            startActivity<MainActivity>()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.ondestroy()

    }

}
