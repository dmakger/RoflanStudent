package com.clown.roflanstudent.json.reader

import com.clown.roflanstudent.domain.model.AuthStudent
import com.clown.roflanstudent.json.JSONGet
import org.json.JSONObject

class AuthJSONReader : JSONReader<AuthStudent> {
    private val url = "https://api.npoint.io/a055c0481ce9e12f8509"
    private val tag = "students"

    override fun getData() = parse(download())

    override fun download() = JSONGet().execute(url).get()

    override fun parse(data: String?): MutableList<AuthStudent>? {
        if (data == null)
            return null
        val list = mutableListOf<AuthStudent>()
        try {
            if (data.isNotEmpty()) {
                val json = JSONObject(data)
                val jsonArray = json.getJSONArray(tag)
                for (i in 0 until jsonArray.length()) {
                    val jsonStudent = jsonArray.getJSONObject(i)
                    val student = parseObject(jsonStudent)
                    list.add(student)
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            return list
        }
    }

    override fun parseObject(jsonObject: JSONObject) = AuthStudent(
        email = jsonObject.getString("email"),
        login = jsonObject.getString("login"),
        password = jsonObject.getString("password")
    )

}