package com.example.myapplication.model

import com.example.myapplication.fragment.Acount_Fragment
import com.example.myapplication.fragment.Home_Fragment
import com.example.myapplication.fragment.Shop_Fragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModelMainActivity: KoinComponent {

    private val Acount_Fragment: Acount_Fragment by inject()
    private val homeFragment: Home_Fragment by inject()
    private val shopFragment: Shop_Fragment by inject()

    companion object{
        const val key_AcountFragment = "Acountfragmetn"
        const val key_HomeFragment = "homefragmetn"
        const val key_ShopFragment = "Shopfragmetn"
    }

    fun setUpViewButom_nav() = 1
    fun setmainfragment() = homeFragment

    fun bottom_nav_setItemOnclick() = mapOf(
        key_AcountFragment to Acount_Fragment,
        key_HomeFragment to homeFragment,
        key_ShopFragment to shopFragment)




}