package com.clown.roflanstudent.json.reader

import com.clown.roflanstudent.domain.model.InfoStudent
import com.clown.roflanstudent.json.JSONGet
import org.json.JSONObject

class InfoJSONReader(private val url: String, private val tag: String): JSONReader<InfoStudent> {

    override fun getData() = parse(download())

    override fun download() = JSONGet().execute(url).get()

    override fun parse(data: String?): MutableList<InfoStudent>? {
        if (data == null)
            return null
        val list = mutableListOf<InfoStudent>()
        try {
            if (data.isNotEmpty()) {
                val json = JSONObject(data).getJSONObject(tag)
                val infoStudent = parseObject(json)
                list.add(infoStudent)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            return list
        }
    }

    override fun parseObject(jsonObject: JSONObject) = InfoStudent(
        name = jsonObject.getString("first name"),
        lastname = jsonObject.getString("last name"),
        middle_name = jsonObject.getString("patronymic"),
        birthday = jsonObject.getString("data of birth"),
        class_ = jsonObject.getString("class"),
    )
}