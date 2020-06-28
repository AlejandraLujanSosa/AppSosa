package com.example.appsosa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*

class Contador : AppCompatActivity() {

    var contador:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)


        btnSuma.setOnClickListener {
                contador = contador +1
                txtContador.text = contador.toString()
            }

            btnResta.setOnClickListener {
                contador = contador -1
                txtContador.text = contador.toString()
            }

            btnReset.setOnClickListener {
                contador = 0
                txtContador.text = ""
            }

            btnSalir.setOnClickListener {
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }




