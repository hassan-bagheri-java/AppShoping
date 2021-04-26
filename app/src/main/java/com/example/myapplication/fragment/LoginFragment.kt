package com.example.myapplication.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.activity.WebActivity
import com.example.myapplication.dataClass.DataLoginWebservice
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.net.ApiService
import com.example.myapplication.presenter.PresenterLoginFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment() : Fragment() {

    private val presenter: PresenterLoginFragment by inject()
    private lateinit var email : String
    private lateinit var password : String
    private lateinit var txtLogin : AppCompatTextView
    private val apiService: ApiService by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        email = edt_email_login_fragment.text.toString()
        password = edt_password_login_fragment.text.toString()
        txtLogin = txt_login_fragment

        txtLogin.setOnClickListener {

            if (testRight()) {

                progressBar_login_fragment.visibility = View.VISIBLE

                val query = "CALL check_login('${edt_email_login_fragment.text.toString()}','${edt_password_login_fragment.text.toString()}')"


                apiService.getAPi()
                    .userLogin(
                        "select","${query}"

                    )
                    .enqueue(object : Callback<DataLoginWebservice> {

                        override fun onFailure(call: Call<DataLoginWebservice>, t: Throwable) {
                            toast("خطای اتصال به اینترنت")
                            progressBar_login_fragment.visibility = View.INVISIBLE
                        }

                        override fun onResponse(
                            call: Call<DataLoginWebservice>,
                            response: Response<DataLoginWebservice>
                        ) {

                            progressBar_login_fragment.visibility = View.INVISIBLE

                            val data = response.body()



                            Log.e("hassan", "${response.body()}")

                            if (data != null) {

                                if (data.data[0].Result == "1") {

                                    val pref =
                                        activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
                                    val editor = pref?.edit()
                                    editor?.putBoolean("login", true)
                                    editor?.putString(
                                        "email",
                                        edt_email_login_fragment.text.toString()
                                    )
                                    editor?.apply()

                                    toast("خوش آمدین :)")



                                    startActivity<MainActivity>()



                                } else
                                    toast("نام کاربری یا پسورد صحیح نمیباشد")

                            }

                        }

                    })

            }

        }

        txt_view_rules_login_fragment.setOnClickListener {
            startActivity<WebActivity>(
                ModelWebView.KEY_URL to "https://www.webroidlearning.ir"
            )
        }

        presenter.oncreate()

    }

    private fun testRight(): Boolean {

        val checkBox = checkBox_login_fragment.isChecked

        return if (edt_email_login_fragment.text.toString()
                .isEmpty() || edt_password_login_fragment.text.toString().isEmpty()
        ) {
            toast("لطفا ایمیل و نام کاربری خود را وارد کنید")
            false
        } else
            if (checkBox)
                true
            else {
                toast("لطفا با قوانین موافقت کنید")
                false
            }

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.ondestroy()

    }

}
