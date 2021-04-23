package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.ScrollView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codesgood.views.JustifiedTextView
import com.example.myapplication.R
import com.example.myapplication.adpter.RecyclerCommentsAdapter
import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataComments
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.net.ApiService
import com.example.myapplication.utility.PicasoUtility
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.CustomView.CustomTextVieForTakhfif
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail.view.*
import org.jetbrains.anko.toast
import org.koin.core.KoinContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

@SuppressLint("ViewConstructor")
class ViewDetailActivity(
    contextInstance: Context,
    private val utility: Utility
) : FrameLayout(contextInstance) , KoinComponent{

    private var change_icon_favarit = false
    private val root : ConstraintLayout
    private val imgback: AppCompatImageView
    private val imgfavrit: AppCompatImageView
    private val title : AppCompatTextView
    private val txtName : AppCompatTextView
    private val txtDescription : JustifiedTextView
    private val txtPrice : AppCompatTextView
    private val txtDiscount: CustomTextVieForTakhfif
    private val txtbuy: AppCompatTextView
    private val imgPreView : AppCompatImageView
    private val ratingBar : AppCompatRatingBar
    private val recycler : RecyclerView
    private val progressbar : ProgressBar
    private val scrollView: ScrollView

    private val picassoUtility: PicasoUtility by inject()

    init {
        val mainView = inflate(context, R.layout.activity_detail, this)

        root = mainView.detail_root
        imgback = mainView.question_imgBack_detail
        imgfavrit = mainView.detail_favrit
        title = mainView.detail_title
        txtName = mainView.txt_name_detail_activity
        txtDescription=mainView.txt_description_detail_activity
        txtPrice=mainView.appCompatTextView3
        txtDiscount=mainView.appCompatTextView2
        txtbuy=mainView.detail_btn
        imgPreView=mainView.img_preview_detail_activity
        ratingBar=mainView.detail_ratinh
        recycler=mainView.recyclerView2
        progressbar=mainView.progress_detail
        scrollView = mainView.scrollView_detail
    }

    fun showSnackBar(title: String) {

        progressbar.visibility = View.INVISIBLE

        val snack = Snackbar.make(
            root,
            title,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.setActionTextColor(Color.CYAN)
        snack.setAction("تلاش مجدد"){ snack.dismiss() ; utility.onRefresh() ; progressbar.visibility = View.VISIBLE}
        snack.show()

    }




    fun onclickHandler() {

        imgback.setOnClickListener {
            utility.onfinished()
        }

        imgfavrit.setOnClickListener {

            change_icon_favarit = if (change_icon_favarit) {

//                ApiService().getAPi().setproductporfroshinFavorite()
                imgfavrit.setImageResource(R.drawable.ic_unlikelike1)
                false

            } else {
                imgfavrit.setImageResource(R.drawable.ic_like)
                true
            }

        }

        txtbuy.setOnClickListener{ context.toast("onclik")}


    }

    fun setDataRecycler(data : List<DataComments>){

        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,true)
        recycler.adapter = RecyclerCommentsAdapter(data)
    }

    fun setUpViews(data : DataProduct){

        picassoUtility.setimage(data.imgAddress , imgPreView)
        txtName.text = data.title
        txtDescription.text = data.description
        ratingBar.rating = data.rate.toFloat()

        if (data.discount == "1") {

            txtDiscount.visibility =View.VISIBLE
            txtDiscount.setCustomText(data.price)
            txtPrice.text = data.priceDiscount
        }else{
            txtDiscount.visibility=View.GONE
            txtPrice.text = data.price
        }




    }

    fun settitle(title1 :String){
        title.text = title1
    }

    fun showToast(error: String) {
        context.toast(error)

    }

    fun hideProgress() {
        progressbar.visibility =View.INVISIBLE
        scrollView.visibility = View.VISIBLE


    }

    fun showProgress() {

    }
}