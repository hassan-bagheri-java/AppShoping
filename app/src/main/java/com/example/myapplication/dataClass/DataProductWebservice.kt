package com.example.myapplication.dataClass

data class DataProductWebservice(
    val status: Int,
    val msg: String,
    val data: List<DataProduct>

)