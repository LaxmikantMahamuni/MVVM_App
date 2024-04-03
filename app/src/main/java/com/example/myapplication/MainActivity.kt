package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {//onCreate(savedInstanc
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convert()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convert() {
        val directory = File(applicationContext.filesDir, "responses")
        val fileName = "object.json"

        val newValue = ""

        val file = File(directory, fileName)
        val content = String(Files.readAllBytes(Paths.get(directory.path, fileName)))

        var responseJson: JSONObject? = null
        var responseJsonArray: JSONArray? = null
        try {
            responseJson = Gson().fromJson(
                "newValue",
                JSONObject::class.java
            )
        } catch (exc: JsonSyntaxException) {
            exc.message?.let { Log.d("", it) }

        } catch (exc: JSONException) {
            exc.message?.let { Log.d("", it) }
        } catch (exc: Exception) {
            exc.message?.let { Log.d("", it) }
        }
    }
}