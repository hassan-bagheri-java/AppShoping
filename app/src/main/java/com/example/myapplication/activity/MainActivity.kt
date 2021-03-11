package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.etc.SetFragment
import com.example.myapplication.model.ModelMainActivity
import com.example.myapplication.presenter.PresenterMainActivity
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.ViewMainActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() ,SetFragment , Utility {

    private val model: ModelMainActivity by inject()
    private lateinit var presenter: PresenterMainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val view_main = ViewMainActivity(this,this,this)
        setContentView(view_main)

        presenter = PresenterMainActivity(view_main, model)
        presenter.oncreate()
    }


    override fun addfragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_framlayout,fragment)
                .commit()

    }

    override fun replacefragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_framlayout,fragment)
            .commit()
    }


    override fun onDestroy() {
        presenter.ondestroy()
        super.onDestroy()
    }

}