package com.example.myapplication.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.parseAsHtml
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adpter.RecycleCategorieAdapter
import com.example.myapplication.dataClass.DataCategoriItem
import com.example.myapplication.dataClass.DataImgBannerUrl
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.presenter.PresenterHomeFragment
import com.example.myapplication.utility.PicasoUtility
import kotlinx.android.synthetic.main.fragment_home_.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val presenter : PresenterHomeFragment by inject()
    private val picasso : PicasoUtility by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        presenter.onresume()
    }

    fun getDataRecycleProduct_new(data : List<DataProduct>){
        home_fragment_recycle_new.initRecycler(data, TypeGetProduct.NEW_PRODUCT) }

    fun getDataRecycleProduct__takhfif(data : List<DataProduct>){
        home_fragment_recycle_takhfif.initRecycler(data,TypeGetProduct.TAKHFIF_PRODUCT) }

    fun getDataRecycleProduct_porforosh(data : List<DataProduct>){
        home_fragment_recycle_porforosh.initRecycler(data, TypeGetProduct.PORFOROSH_PRODUCT) }


    fun setDataRecycleCategory(data :List<DataCategoriItem>){
        home_Fragment_recycle_categori.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
        home_Fragment_recycle_categori.adapter = RecycleCategorieAdapter(context,data)
    }

    fun setImageInBannerr(data : DataImgBannerUrl){
        picasso.setimage(data.image1,home_fragment_banner1)
        picasso.setimage(data.image2,home_fragment_banner2)

        home_fragment_banner1.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data.clickimage1)
            startActivity(intent)
        }

        home_fragment_banner2.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data.clickimage2)
            startActivity(intent)
        }
    }

    fun showToast(text: String){
        context?.toast(text)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.ondestroy()
    }

}