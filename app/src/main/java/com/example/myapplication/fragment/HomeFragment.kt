package com.example.myapplication.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.text.parseAsHtml
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adpter.RecycleCategorieAdapter
import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.presenter.PresenterHomeFragment
import com.example.myapplication.utility.PicasoUtility
import kotlinx.android.synthetic.main.activity_more.*
import kotlinx.android.synthetic.main.fragment_home_.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val presenter : PresenterHomeFragment by inject()
    private val picasso : PicasoUtility by inject()
    private lateinit var img_baner1:AppCompatImageView
    private lateinit var recycle_categori:RecyclerView
    private lateinit var img_baner2:AppCompatImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        img_baner1 = home_fragment_banner1
        img_baner2 = home_fragment_banner2
        recycle_categori = home_Fragment_recycle_categori
        presenter.oncreate()

    }

    override fun onResume() {
        super.onResume()
       showProgress()
    }

    fun getDataRecycleProduct_new(data : List<DataProduct>){
        home_fragment_recycle_new.initRecycler(data, TypeGetProduct.NEW_PRODUCT) }

    fun getDataRecycleProduct__takhfif(data : List<DataProduct>){
        home_fragment_recycle_takhfif.initRecycler(data,TypeGetProduct.TAKHFIF_PRODUCT) }

    fun getDataRecycleProduct_porforosh(data : List<DataProduct>){
        home_fragment_recycle_porforosh.initRecycler(data, TypeGetProduct.PORFOROSH_PRODUCT)
        hideProgress()
    }


    fun setDataRecycleCategory(data :List<DataCategoriItem>){
        recycle_categori.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
        recycle_categori.adapter = RecycleCategorieAdapter(context,data)
    }

    fun setImageInBannerr(data : DataImgBannerUrl){
        picasso.setimage(data.image1,img_baner1)
        picasso.setimage(data.image2,img_baner2)

        img_baner1.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data.clickimage1)
            startActivity(intent)
        }

        img_baner2.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data.clickimage2)
            startActivity(intent)
        }
    }

    fun showToast(text: String){
        context?.toast(text)
    }

    private fun showProgress(){
        home_Fragment_progeresbar.visibility = View.VISIBLE
        home_frament_root.visibility = View.INVISIBLE
    }

    private  fun hideProgress(){
        home_Fragment_progeresbar.visibility = View.INVISIBLE
        home_frament_root.visibility = View.VISIBLE
    }




    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }

}