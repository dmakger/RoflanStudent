package com.clown.roflanstudent.json

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class JSONGet: AsyncTask<String, Void, String?>() {
    override fun doInBackground(vararg urls: String?): String? {
        var data: String? = null
        try {
            val url = URL(urls[0])
            val httpURLConnection = url.openConnection() as HttpURLConnection
            val inputStream = httpURLConnection.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream))

            data = ""
            for (line in reader.readLine())
                data += line
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            return data
        }

    }

}