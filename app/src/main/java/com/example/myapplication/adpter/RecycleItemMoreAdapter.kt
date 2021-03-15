package com.example.myapplication.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.utility.PicasoUtility
import kotlinx.android.synthetic.main.item_recycler_product_view.view.*
import org.jetbrains.anko.toast
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class RecycleItemMoreAdapter(private val context: Context, private val data: List<DataProduct>) :
    RecyclerView.Adapter<RecycleItemMoreAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_moreactivity, parent, false)
        )


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), KoinComponent {


        private val picasso: PicasoUtility by inject()
        private val rootview = itemView.item_recycle_product_product
        private val img = itemView.item_recycle_product_img_product
        private val title = itemView.item_recycle_product_name_product
        private val price = itemView.item_recycle_product_real_price
        private val takhfif = itemView.item_recycle_product_takhfif

        fun setData(data: DataProduct) {

            picasso.setimage(data.imgAddress, img)
            title.text = data.title

            if (data.takhfif) {
                takhfif.visibility = View.VISIBLE
                takhfif.setCustomText(data.price)
                price.text = data.pricetakhfif
            } else {
                takhfif.visibility = View.INVISIBLE
                price.text = data.price
            }

            rootview.setOnClickListener {
                context.toast("onclick")
            }
        }
    }


}