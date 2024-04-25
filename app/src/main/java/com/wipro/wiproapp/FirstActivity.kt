package com.wipro.wiproapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wipro.wiproapp.databinding.ActivityMapsBinding
import com.wipro.wiproapp.view.MainActivity

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this@FirstActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}