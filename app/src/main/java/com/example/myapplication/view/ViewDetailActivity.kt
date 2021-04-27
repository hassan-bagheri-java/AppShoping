package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
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
import com.example.myapplication.activity.MainActivity
import com.example.myapplication.adpter.RecyclerCommentsAdapter
import com.example.myapplication.dataClass.*
import com.example.myapplication.net.ApiService
import com.example.myapplication.utility.PicasoUtility
import com.example.myapplication.utility.Utility
import com.example.myapplication.view.CustomView.CustomTextVieForTakhfif
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import org.koin.core.KoinContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    private val apiService:  ApiService by inject()
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




    fun onclickHandler(id : String) {

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

        txtbuy.setOnClickListener{

            val pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
            val email = pref.getString("email", "default")
            val query = "CALL insert_cart($id,'${email}')"

            Log.e("hassan", "${query}")

            apiService.getAPi()
                .insert_cart(
                    "insert","${query}"

                )
                .enqueue(object : Callback<DataInsert> {

                    override fun onFailure(call: Call<DataInsert>, t: Throwable) {
                        context.toast("خطای اتصال به اینترنت")
                    }

                    override fun onResponse(
                        call: Call<DataInsert>,
                        response: Response<DataInsert>
                    ) {


                        val data = response.body()



                        Log.e("hassan", "${response.body()}")

                        if (data != null) {

                            if (data.status == 200) {

                                context.toast("کالا با موقعیت به سبد خرید شما اضافه شد.")

                            } else

                                context.toast("مشکلی در اضافه کردن به سبد خرید ایجاد شده است.")

                        }

                    }

                })
        }


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