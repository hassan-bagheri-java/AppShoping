package com.example.myapplication.etc

interface BaseLifeCycle {


    fun oncreate()

    fun ondestroy()

    fun onrefresh(){}

    fun onstop(){}

    fun onresume(){}
}