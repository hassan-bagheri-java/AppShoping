package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.utility.Utility
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_login.view.*

@SuppressLint("ViewConstructor")
class ViewLoginActivity(
    contextInstance: Context,
    private val utility: Utility
) : FrameLayout(contextInstance) {

    private val root: ConstraintLayout
    private val tabLayout: TabLayout
    private val viewPager: ViewPager

    init {

        val mainView = inflate(context, R.layout.activity_login, this)

        root = mainView.root_login_activity
        tabLayout = mainView.tabLayout_login_activity
        viewPager = mainView.viewPager_login_activity

    }

    fun checkInternet(netInfo: Boolean) {

        if (netInfo) {
            tabLayout.visibility = View.VISIBLE
            viewPager.visibility = View.VISIBLE
        } else
            showSnackBar()

    }

//    fun setUpTabLayout(
//        adapter: ViewPagerAdapter,
//        login: LoginFragment,
//        register: RegisterFragment
//    ) {
//
//        adapter.addFragment(login, "ورود")
//        adapter.addFragment(register, "ثبت نام")
//
//        viewPager.adapter = adapter
//        tabLayout.setupWithViewPager(viewPager)
//
//    }

    private fun showSnackBar() {

        val snack = Snackbar.make(
            root,
            "خطای اتصال به اینترنت",
            Snackbar.LENGTH_INDEFINITE
        )
        snack.setActionTextColor(Color.CYAN)
        snack.setAction("تلاش مجدد") {
            snack.dismiss(); utility.onRefresh()
        }
        snack.show()

    }

}