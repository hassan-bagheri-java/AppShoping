package com.example.myapplication.aapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataProdyct
import kotlinx.android.synthetic.main.item_recycler_product_view.view.*

class RecycleItemProductAdapter(private val data: List<DataProdyct>) :
    RecyclerView.Adapter<RecycleItemProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_product_view, parent, false)
        )


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position])
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val rootview = itemView.item_recycle_product_product
        private val img = itemView.item_recycle_product_img_product
        private val title = itemView.item_recycle_product_name_product
        private val price = itemView.item_recycle_product_real_price
        private val takhfif = itemView.item_recycle_product_takhfif
        
        fun setData(data: DataProdyct){}
    }


}