package com.clown.roflanstudent.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.clown.roflanstudent.R
import com.clown.roflanstudent.json.reader.InfoJSONReader
import com.clown.roflanstudent.urls.GetURLs
import kotlinx.android.synthetic.main.activity_profile_screen.*

class ProfileScreen : AppCompatActivity() {

    var login: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        initialization()
    }

    private fun initialization() {
        login = this.intent.getStringExtra("studentLogin")
        if (login != null) {
            val url = GetURLs().urls[login]
            val data = InfoJSONReader(url!!.info, login!!).getData()?.get(0)

            if (data != null) {
                txtName.text = "${data.lastname} ${data.name} ${data.middle_name}"
                txtClass.text = data.class_
                txtBirthday.text = data.birthday
            }
        }
    }

    fun onClickLessons(view: View) {
        val intent = Intent(this, SchoolSubjectsScreen::class.java)
        intent.putExtra("studentLogin", login!!)
        startActivity(intent)

    }
}