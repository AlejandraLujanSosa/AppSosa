package com.example.appsosa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ingresarBtn.setOnClickListener {

            val intent:Intent= Intent ( this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}
