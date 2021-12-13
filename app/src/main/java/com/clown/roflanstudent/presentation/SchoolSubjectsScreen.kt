package com.clown.roflanstudent.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.clown.roflanstudent.R
import com.clown.roflanstudent.domain.model.ResultStudent
import com.clown.roflanstudent.json.reader.ResultJSONReader
import com.clown.roflanstudent.presentation.adapter.LessonListAdapter
import com.clown.roflanstudent.urls.GetURLs
import kotlinx.android.synthetic.main.activity_grades_screen.*
import kotlinx.android.synthetic.main.activity_school_subjects_screen.*
import kotlinx.android.synthetic.main.activity_school_subjects_screen.imgBack

class SchoolSubjectsScreen : AppCompatActivity(), LessonListAdapter.Listener {
    private var login: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_subjects_screen)

        initialization()
    }

    private fun initialization() {
        login = intent.getStringExtra("studentLogin")

        val adapter = LessonListAdapter(this)
        listLesson.adapter = adapter
        listLesson.layoutManager = LinearLayoutManager(this)

        val url = GetURLs().urls[login]
        if (login != null) {
            val data = ResultJSONReader(url!!.rating).getData()
            if (data != null)
                for (resultStudent in data)
                    adapter.addItem(resultStudent)
        }

        imgBack.setOnClickListener { finish() }

    }

    override fun onItemClick(resultStudent: ResultStudent) {
        val intent = Intent(this, GradesScreen::class.java)
        intent.putExtra("resultStudent", resultStudent)
        startActivity(intent)
    }
}