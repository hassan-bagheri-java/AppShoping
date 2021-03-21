package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adpter.RecyclerQuestionAdapter
import com.example.myapplication.dataClass.DataQuestion
import com.example.myapplication.utility.Utility
import kotlinx.android.synthetic.main.activity_more.view.question_imgBack
import kotlinx.android.synthetic.main.activity_question.view.*
import org.jetbrains.anko.toast

@SuppressLint("ViewConstructor")
class ViewQuestionActivity (contextInstance: Context,
                            private val utility: Utility) : FrameLayout(contextInstance){

    private val imgback : AppCompatImageView
    private val progress : ProgressBar
    private val recyclerView : RecyclerView

    init {
        val mainView = View.inflate(context, R.layout.activity_question, this)

        imgback = mainView.question_imgBack
        progress = mainView.question_progress
        recyclerView = mainView.recycler_questuin
    }

    fun initRecycler(data : List<DataQuestion>){
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL ,false)

        recyclerView.adapter = RecyclerQuestionAdapter(data)
        showProgress()
    }

    private fun showProgress () {
        recyclerView.visibility = View.INVISIBLE
        progress.visibility = View.VISIBLE
    }

    fun hideProgress () {
        recyclerView.visibility = View.VISIBLE
        progress.visibility = View.INVISIBLE
    }


    fun onclickBack(){
        imgback.setOnClickListener { utility.onfinished() }
    }

    fun showToast(text :String){
        context.toast(text)
    }
}