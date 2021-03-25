package com.example.myapplication.model

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.fragment.LoginFragment
import com.example.myapplication.utility.NetworkChecker

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModelLoginActivity(private val context: AppCompatActivity) : KoinComponent {

    private val login: LoginFragment by inject()
    private val register: RegisterFragment by inject()

    fun checkNetInfo() = NetworkChecker(context).networkState()

    fun getObjectLogin() = login

    fun getObjectRegister() = register

    fun getAdapter() = ViewPagerAdapter(context.supportFragmentManager)

}