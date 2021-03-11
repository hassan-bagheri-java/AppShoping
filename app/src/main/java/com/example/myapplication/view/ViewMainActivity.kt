package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.etc.SetFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.view.*

@SuppressLint("ViewConstructor")
class ViewMainActivity(contextInstance :Context, private val  setFragment: SetFragment) : FrameLayout(contextInstance){

    private val bottom_nav :BottomNavigationView

    init {
        val view = inflate(context, R.layout.activity_main,this)
        bottom_nav = view.bottomNavigationView
    }


/**
 * in baraye check kard default hast
 */
    fun setUpViewButom_nav(itemChecked : Int, mainfargment : Fragment){
        bottom_nav.menu.getItem(itemChecked).isChecked = true
        setFragment.addfragment(mainfargment)
    }


}