package com.example.myapplication.dataClass

data class DataLoginWebservice(
    val `data`: List<Data>,
    val msg: String,
    val status: Int
)

data class Data(
    val Result: String
)