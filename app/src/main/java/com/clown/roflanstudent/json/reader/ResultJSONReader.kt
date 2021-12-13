package com.clown.roflanstudent.json.reader

import android.util.Log
import com.clown.roflanstudent.domain.model.DateResultStudent
import com.clown.roflanstudent.domain.model.ResultStudent
import com.clown.roflanstudent.json.JSONGet
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class ResultJSONReader(private val url: String): JSONReader<ResultStudent> {
    private val tag = "grades"

    override fun getData() = parse(download())

    override fun download() = JSONGet().execute(url).get()

    override fun parse(data: String?): MutableList<ResultStudent>? {
        if (data == null)
            return null
        val list = mutableListOf<ResultStudent>()
        try {
            if (data.isNotEmpty()) {
                val json = JSONObject(data).getJSONObject(tag)
                for (key in json.keys()) {
                    val results = json.getJSONArray(key)
                    val resultStudent = getObject(key, results)
                    list.add(resultStudent)
                }

            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            return list
        }
    }

    private fun getObject(lesson: String, JSONResults: JSONArray): ResultStudent {
        val results = mutableListOf<DateResultStudent>()
        for (i in 0 until JSONResults.length()) {
            val json = JSONResults.getJSONObject(i)
            val date = json.names()[0].toString()
            val result = json.get(date).toString().toInt()
            results.add(DateResultStudent(date, result))
        }
        return ResultStudent(lesson, results)
    }

    override fun parseObject(jsonObject: JSONObject): ResultStudent? {
        TODO("Not yet implemented")
    }
}