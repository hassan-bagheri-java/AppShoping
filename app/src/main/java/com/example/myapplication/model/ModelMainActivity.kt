package com.example.myapplication.model

import androidx.fragment.app.Fragment
import com.example.myapplication.di.fragment
import com.example.myapplication.fragment.Acount_Fragment
import com.example.myapplication.fragment.Home_Fragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModelMainActivity: KoinComponent {

    private val homeFragment: Home_Fragment by inject()

    fun setUpViewButom_nav() = 1
    fun setmainfragment() = homeFragment

}