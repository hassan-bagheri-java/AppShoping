package com.example.myapplication.net

interface CountryPreesenterListner<M> {

    fun onResponse(data : M)

    fun onFailure(error:String)
}