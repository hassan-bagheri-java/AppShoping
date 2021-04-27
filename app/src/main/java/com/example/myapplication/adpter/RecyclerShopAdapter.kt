package com.example.myapplication.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.utility.PicasoUtility
import kotlinx.android.synthetic.main.item_recycler_shop.view.*
import org.jetbrains.anko.layoutInflater
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class RecyclerShopAdapter (private val data : List<DataProduct>):
RecyclerView.Adapter<RecyclerShopAdapter.ShopViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShopViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_shop,
                parent,
                false)
        )

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.setData(data[position])
    }

    override fun getItemCount() = data.size




    inner class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), KoinComponent {

        private val picasoUtility: PicasoUtility by inject()
        private val imgProduct = itemView.img_product_shop_recycler
        private val txtName = itemView.txt_name_shop_recycler
        private val txtPrice = itemView.txt_price_shop_recycler
        private val txtDiscount = itemView.txt_discount_shop_recycler
        private val ratingBar = itemView.ratingBar_shop_recycler

        fun setData(data : DataProduct){

            picasoUtility.setimage(data.imgAddress,imgProduct)
            txtName.text = data.title

            if (data.discount == "1") {
                txtDiscount.visibility = View.VISIBLE
                txtPrice.text = data.priceDiscount
                txtDiscount.text = data.price
            } else {
                txtDiscount.visibility = View.INVISIBLE
                txtPrice.text = data.price
            }

            ratingBar.rating = data.rate.toFloat()
        }

    }

}