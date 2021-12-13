package com.clown.roflanstudent.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.clown.roflanstudent.R
import com.clown.roflanstudent.domain.model.ResultStudent
import com.clown.roflanstudent.presentation.adapter.ResultListAdapter
import kotlinx.android.synthetic.main.activity_grades_screen.*

class GradesScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grades_screen)

        initialization()
    }

    private fun initialization() {
        val adapter = ResultListAdapter()

        listResult.adapter = adapter
        listResult.layoutManager = LinearLayoutManager(this)

        val resultStudent = intent.getParcelableExtra<ResultStudent>("resultStudent")
        if (resultStudent != null) {
            txtTitleLesson.text = resultStudent.lesson
            for (result in resultStudent.result) {
                adapter.addItem(result)
            }
        }

        imgBack.setOnClickListener { finish() }

    }
}