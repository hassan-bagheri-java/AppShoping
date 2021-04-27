package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.model.ModelAcountFragment
import com.example.myapplication.presenter.PresenterAcountFragment
import kotlinx.android.synthetic.main.fragment_account.*


class Acount_Fragment : Fragment() {

    private lateinit var presenter : PresenterAcountFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val model = ModelAcountFragment(activity?.applicationContext)

        presenter = PresenterAcountFragment(this,model)
        presenter.oncreate()

    }

    fun setDataUser(name : String , email : String){

        txt_name_account_fragment.text = name
        txt_email_account_fragment.text = email

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }
}