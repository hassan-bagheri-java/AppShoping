package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.etc.SetFragment
import com.example.myapplication.model.ModelMainActivity
import com.example.myapplication.presenter.PresenterMainActivity
import com.example.myapplication.view.ViewMainActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() ,SetFragment {

    private val model: ModelMainActivity by inject()
    private lateinit var presenter: PresenterMainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val view = ViewMainActivity(this,this)
        setContentView(view)

        presenter = PresenterMainActivity(view, model)
        presenter.oncreate()
    }

    override fun onDestroy() {
        presenter.ondestroy()
        super.onDestroy()
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
}