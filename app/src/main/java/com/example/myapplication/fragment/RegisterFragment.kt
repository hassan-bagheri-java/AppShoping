package com.example.myapplication.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.activity.WebActivity
import com.example.myapplication.dataClass.DataInsert
import com.example.myapplication.model.ModelWebView
import com.example.myapplication.net.ApiService
import com.example.myapplication.presenter.PresenterRegisterFragment
import kotlinx.android.synthetic.main.fragment_register.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {

    private val presenter: PresenterRegisterFragment by inject()
    private lateinit var email : String
    private lateinit var password : String
    private lateinit var txtRegister : AppCompatTextView
    private lateinit var txtRules : AppCompatTextView
    private lateinit var checkBox : AppCompatCheckBox


    init {

    }


    private val apiService: ApiService by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        email = edt_email_register_fragment.text.toString()
        password = edt_password_register_fragment.text.toString()
        txtRegister = txt_register_fragment
        txtRules = txt_view_rules_register_fragment
        checkBox = checkBox_register_fragment




        txtRegister.setOnClickListener {

            if (testRight()) {


                val query = "CALL login('${email}','${password}')"

                apiService.getAPi()
                    .userRegister(
                        "insert","${query}"

                    )
                    .enqueue(object : Callback<DataInsert> {

                        override fun onFailure(call: Call<DataInsert>, t: Throwable) {
                            toast("خطای اتصال به اینترنت")
//                            progressBar_login_fragment.visibility = View.INVISIBLE
                        }

                        override fun onResponse(
                            call: Call<DataInsert>,
                            response: Response<DataInsert>
                        ) {

//                            progressBar_login_fragment.visibility = View.INVISIBLE

                            val data = response.body()

                            if (data != null) {

                                if (data.status == 200) {

                                    val pref =
                                        activity?.getSharedPreferences("pref", Context.MODE_PRIVATE)
                                    val editor = pref?.edit()
                                    editor?.putBoolean("login", true)
                                    editor?.putString(
                                        "email",
                                        email
                                    )
                                    editor?.apply()

                                    toast("ثبت نام با موقعیت انجام شد")

                                    startActivity<MainActivity>()

                                } else
                                    toast("نام کاربری یا پسور قبلا ثبت شده است")

                            }

                        }

                    })

            }

        }

        txtRules.setOnClickListener {
            startActivity<WebActivity>(
                ModelWebView.KEY_URL to "https://www.webroidlearning.ir"
            )
        }

        presenter.oncreate()

    }

    private fun testRight(): Boolean {

        val checkBox = checkBox.isChecked
        email = edt_email_register_fragment.text.toString()
        password = edt_password_register_fragment.text.toString()


        return if (email.isEmpty() || password.isEmpty()
        ) {

            toast("لطفا ایمیل و نام کاربری خود را وارد ")
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
