package com.example.myapplication.dataClass

data class DataUserWebservice(
    val `data`: List<DataUser>,
    val msg: String,
    val status: Int
)

data class DataUser(
    val email: String,
    val userName: String
)