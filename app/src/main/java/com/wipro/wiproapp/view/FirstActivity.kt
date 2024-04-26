package com.wipro.wiproapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.wipro.wiproapp.R

/**
 * This class is the view where user will se the UI and he/she can
 * perform operations on it lik button press, text input etc.
 */
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