package com.example.myapplication.etc

import androidx.fragment.app.Fragment

interface SetFragment {

    fun addfragment(fragment: Fragment)

    fun replacefragment(fragment: Fragment)
}