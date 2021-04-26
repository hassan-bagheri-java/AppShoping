package com.example.myapplication.view

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.net.Uri
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.AlertDialogLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activity.AboutMeActivity
import com.example.myapplication.activity.LoginActivity
import com.example.myapplication.activity.questionActivity
import com.example.myapplication.etc.SetFragment
import com.example.myapplication.model.ModelMainActivity
import com.example.myapplication.net.ApiService
import com.example.myapplication.utility.Utility
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.dialog_call_me.view.*
import kotlinx.android.synthetic.main.dialog_failure_report.view.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("ViewConstructor")
class ViewMainActivity(
    contextInstance: Context,
    private val utility : Utility,
    private val setFragment: SetFragment
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

                R.id.menu_main_exit ->{

                    val pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putBoolean("login", false)
                    editor.apply()

                    context.startActivity<LoginActivity>()
                    utility.onfinished()



                    true

                }
                else -> false
            }
        }
    }


    @SuppressLint("InflateParams")
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_main_porsesh -> {
//            context.toast("پرسش های متداول")
                context.startActivity<questionActivity>()
                true
            }
            R.id.menu_main_about -> {
//            context.toast("درباره ما")
                context.startActivity<AboutMeActivity>()
                true
            }
            R.id.menu_main_call -> {
//
//            context.toast("تماس باما")
                val view = LayoutInflater.from(context).inflate(R.layout.dialog_call_me, null)
                val dialog = AlertDialog.Builder(context)

                dialog.setView(view)
                dialog.show()

                view.txt_call_me.setOnClickListener {

                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:09194183978")
                    if (intent.resolveActivity(context.packageManager) != null)
                        context.startActivity(intent)

                }
                true
            }
            R.id.menu_main_error -> {
//                context.toast("'گزارش خطا")
                val view =
                    LayoutInflater.from(context).inflate(R.layout.dialog_failure_report, null )

                AlertDialog.Builder(context , R.style.DialogTheme)
                    .setView(view)
                    .setPositiveButton("ارسال"){ dialog, _ ->

                        val subject = view.edt_subject_dialog_failure_report.text.toString()
                        val text = view.edt_text_dialog_failure_report.text.toString()

                        if (subject.isEmpty() || text.isEmpty())
                            context.toast("لطفا فیلد ها رو پرکنید ")
                        else{
                            ApiService()
                                .getAPi()
                                .sendFailureReport(subject,text)
                                .enqueue(object : Callback<Boolean>{
                                    override fun onFailure(call: Call<Boolean>, t: Throwable) {
                                        context.toast("ارسال گزارش با خطا مواجه شد")
                                    }

                                    override fun onResponse(
                                        call: Call<Boolean>,
                                        response: Response<Boolean>
                                    ) {
                                        context.toast("با موفقعیت ارسال شد")
                                    }

                                })
                        }

                        dialog.dismiss()
                    }
                    .setNegativeButton("لغو") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setCancelable(false)
                    .show()
                true
            }
            R.id.menu_main_exit -> {
                val pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
               val editor = pref.edit()
                editor.putBoolean("login", false)
                editor.apply()
                context.startActivity<LoginActivity>()
                utility.onfinished()
                true
            }
            else -> false
        }
    }


    fun menuup() {
        val popup = PopupMenu(context, menu)
        popup.menuInflater.inflate(R.menu.menu_main, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }


}