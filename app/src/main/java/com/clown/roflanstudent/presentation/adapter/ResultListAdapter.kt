package com.clown.roflanstudent.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clown.roflanstudent.R
import com.clown.roflanstudent.domain.model.DateResultStudent
import kotlinx.android.synthetic.main.listitem_result.view.*

class ResultListAdapter: RecyclerView.Adapter<ResultListAdapter.MyViewHolder>() {

    private val list = mutableListOf<DateResultStudent>()

    inner class MyViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.listitem_result, parent, false)
    ) {
        fun bind(dateResultStudent: DateResultStudent) = with(itemView) {
            txtDate.text = dateResultStudent.date
            txtResult.text = dateResultStudent.result.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addItem(dateResultStudent: DateResultStudent) {
        list.add(dateResultStudent)

        notifyItemInserted(list.lastIndex)
    }
}