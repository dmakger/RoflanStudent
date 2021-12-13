package com.clown.roflanstudent.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.clown.roflanstudent.R
import com.clown.roflanstudent.domain.model.AuthStudent
import com.clown.roflanstudent.json.reader.AuthJSONReader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listStudent = AuthJSONReader().getData()
    private var authStudent: AuthStudent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()
    }

    private fun initialization() {
        txtWarning.visibility = View.GONE
    }

    fun onClickLogin(view: View) {
        var email = etEmail.text.toString().trim()
        var password = etPassword.text.toString().trim()
        if (isInvalid(email, password) && authStudent(email, password)) {
            txtWarning.visibility = View.GONE
            val intent = Intent(this, ProfileScreen::class.java)
            intent.putExtra("studentLogin", this.authStudent!!.login)
            startActivity(intent)
        } else {
            txtWarning.visibility = View.VISIBLE
        }
    }

    private fun isInvalid(email: String, password: String): Boolean {
        var isEmail = email.isNotEmpty() && "@" in email && "." in email
        var isPassword = password.isNotEmpty()
        return isEmail && isPassword
    }

    private fun authStudent(email: String, password: String): Boolean {
        if (listStudent != null)
            for (student in listStudent) {
                if (student.email == email && student.password == password) {
                    this.authStudent = student
                    return true
                }
            }
        return false
    }

}