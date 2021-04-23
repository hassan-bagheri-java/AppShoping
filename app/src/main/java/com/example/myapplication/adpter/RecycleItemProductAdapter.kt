package com.example.myapplication.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activity.DetailActivity
import com.example.myapplication.dataClass.DataProduct
import com.example.myapplication.enum.TypeGetProduct
import com.example.myapplication.utility.PicasoUtility
import kotlinx.android.synthetic.main.item_recycler_product_view.view.*
import org.jetbrains.anko.startActivity
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class RecycleItemProductAdapter(
    private val context: Context,
    private val data: List<DataProduct>,
    private val type: TypeGetProduct
) :
    RecyclerView.Adapter<RecycleItemProductAdapter.ViewHolder>() {

    companion object {

        const val KEY_ID = "id"
        const val KEY_TYPE = "type"
        const val KEY_TITTLE = "title"

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycler_product_view, parent, false)
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
        private val takhfif_price = itemView.item_recycle_product_takhfif

        fun setData(data: DataProduct) {

            picasso.setimage(data.imgAddress, img)
            title.text = data.title

            if (data.discount == "1") {
                takhfif_price.visibility = View.VISIBLE
                takhfif_price.setCustomText(data.price)
                price.text = data.priceDiscount
            } else {
                takhfif_price.visibility = View.VISIBLE
                price.text = data.price
            }

            rootview.setOnClickListener {
                context.startActivity<DetailActivity>(
                    KEY_ID to data.id,
                    KEY_TYPE to type,
                    KEY_TITTLE to data.title
                )
            }
        }
    }


}