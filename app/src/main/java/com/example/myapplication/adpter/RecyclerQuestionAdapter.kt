package com.example.myapplication.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataClass.DataQuestion
import kotlinx.android.synthetic.main.item_recycler_question.view.*

class RecyclerQuestionAdapter (
    private val data : List<DataQuestion>
) : RecyclerView.Adapter<RecyclerQuestionAdapter.QestionViewHolder>(){


    inner class QestionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val txtQuestion = itemView.txt_question_recycler_question
        private val txtAnswer = itemView.txt_answer_recycler_question
        fun setData (data : DataQuestion){

            txtQuestion.text = data.question
            txtAnswer.text = data.answer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        QestionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_recycler_question,
                    parent,
                    false
                )
        )


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: QestionViewHolder, position: Int) {
        holder.setData(data[position])
    }
}