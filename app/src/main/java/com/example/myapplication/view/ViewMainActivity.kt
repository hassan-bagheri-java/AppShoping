package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ColorSpace
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.PopupMenu
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.etc.SetFragment
import com.example.myapplication.model.ModelMainActivity
import com.example.myapplication.utility.Utility
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.toast

@SuppressLint("ViewConstructor")
class ViewMainActivity(
    contextInstance: Context,
    private val setFragment: SetFragment,
    private val utility: Utility
) :
    FrameLayout(contextInstance), PopupMenu.OnMenuItemClickListener {

    private val bottom_nav: BottomNavigationView
    private val menu: AppCompatImageView

    init {
        val view = inflate(context, R.layout.activity_main, this)
        bottom_nav = view.bottomNavigationView
        menu = view.main_menu
    }


    /**
     * in baraye check kard default hast
     */
    fun setUpViewButom_nav(itemChecked: Int, mainfargment: Fragment) {
        bottom_nav.menu.getItem(itemChecked).isChecked = true
        setFragment.addfragment(mainfargment)

        menu.setOnClickListener {
            menuup()
        }
    }

    fun bottom_nav_setItemOnclick(fragments: Map<String, Fragment>) {
        bottom_nav.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.item_menu_account -> {
                    setFragment.replacefragment(
                        fragments[ModelMainActivity.key_AcountFragment] ?: Fragment()
                    )
                    true

                }

                R.id.item_menu_home -> {
                    setFragment.replacefragment(
                        fragments[ModelMainActivity.key_HomeFragment] ?: Fragment()
                    )
                    true

                }

                R.id.item_menu_shop -> {
                    setFragment.replacefragment(
                        fragments[ModelMainActivity.key_ShopFragment] ?: Fragment()
                    )
                    true

                }
                else -> false
            }
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
    return when(item?.itemId){
        R.id.menu_main_porsesh -> {
            context.toast("پرسش های متداول")
            true
        }
        R.id.menu_main_about -> {
            context.toast("درباره ما")
            true
        }
        R.id.menu_main_call -> {context.toast("تماس باما")
            true}
        R.id.menu_main_error -> {
            context.toast("'گزارش خطا")
            true
        }else -> false
    }
    }


    fun menuup(){
        val popup = PopupMenu(context,menu)
        popup.menuInflater.inflate(R.menu.menu_main,popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }


}