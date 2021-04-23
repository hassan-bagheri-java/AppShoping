package com.example.myapplication.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataComments
import kotlinx.android.synthetic.main.item_recycler_comments.view.*

class RecyclerCommentsAdapter (private val data : List <DataComments>) : RecyclerView.Adapter<RecyclerCommentsAdapter.CommentsViewHolder>() {

    inner class CommentsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val txtName = itemView.txt_name_recycler_comments
        private val txtComment = itemView.txt_comment_recycler_comments

        fun setData(data : DataComments) {

            txtComment.text = data.commet
            txtName.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
       CommentsViewHolder(
           LayoutInflater.from(parent.context)
               .inflate(
                   R.layout.item_recycler_comments,parent,false))


    override fun getItemCount() =data.size

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.setData(data[position])
    }
}