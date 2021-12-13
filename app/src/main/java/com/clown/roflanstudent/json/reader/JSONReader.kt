package com.clown.roflanstudent.json.reader

import org.json.JSONObject

interface JSONReader<T> {
    fun getData(): MutableList<T>?
    fun download(): String?
    fun parse(data: String?): MutableList<T>?
    fun parseObject(jsonObject: JSONObject): T?
}