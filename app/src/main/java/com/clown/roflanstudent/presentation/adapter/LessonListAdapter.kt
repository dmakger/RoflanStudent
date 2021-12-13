package com.clown.roflanstudent.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clown.roflanstudent.R
import com.clown.roflanstudent.domain.model.ResultStudent
import kotlinx.android.synthetic.main.listitem_lesson.view.*

class LessonListAdapter(private val listener: Listener): RecyclerView.Adapter<LessonListAdapter.MyViewHolder>() {
    private val list = mutableListOf<ResultStudent>()

    interface Listener {
        fun onItemClick(resultStudent: ResultStudent)
    }

    inner class MyViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.listitem_lesson, parent, false)
    ) {
        fun bind(resultStudent: ResultStudent) = with(itemView) {
            txtLesson.text = resultStudent.lesson
            setOnClickListener{
                listener.onItemClick(resultStudent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addItem(resultStudent: ResultStudent) {
        list.add(resultStudent)
        notifyItemInserted(list.lastIndex)
    }
}