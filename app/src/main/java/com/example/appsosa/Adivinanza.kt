package com.example.appsosa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.ViewPropertyAnimatorUpdateListener
import kotlinx.android.synthetic.main.activity_adivinanza.*
import kotlinx.android.synthetic.main.activity_perfil.*

class Adivinanza : AppCompatActivity() {
    val numeroSecreto = (Math.random() * 100).toInt()

    var vidas: Int = 10
    var intentos: Int = 0
    var numAyuda: Int = 3
    var ayuda: Int = 1
    var cantidadAyuda: Int = numeroSecreto * 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_adivinanza)

            txtOportunidades.text = "Intentos Restantes: $vidas"
            txtIntentos.text = "Cantidad de Intentos: $intentos"
            txtAyuda.text = "Pistas Restantes: $numAyuda"

            AydaBtn.setOnClickListener {
                when (ayuda) {
                    1 ->
                        if (numeroSecreto <= 50) {
                            Toast.makeText(this, "El Número Es Menor a 51 ", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(this, "El Número Es Mayor a 50 ", Toast.LENGTH_LONG)
                                .show()
                        }

                    2 ->
                        if (numeroSecreto % 2 == 0) {
                            Toast.makeText(this, "El Número es PAR", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "El Número es IMPAR", Toast.LENGTH_LONG).show()
                        }
                    3 ->

                        if (numeroSecreto <= 100) {
                            Toast.makeText(
                                this,
                                "(El Número Es igual a $cantidadAyuda /2) ",
                                Toast.LENGTH_LONG
                            ).show()
                        }


                }

                ayuda = ayuda + 1
                if (numAyuda > 0) {
                    numAyuda = numAyuda - 1
                    txtAyuda.text = "Ayudas disponibles: " + numAyuda
                }

            }

            BtnFin.setOnClickListener {
                Toast.makeText(this, "El Número Secreto es: $numeroSecreto", Toast.LENGTH_LONG)
                    .show()
                jugarBtn.isEnabled = false
                AydaBtn.isEnabled = false
                numeroIngresado.isEnabled = false
                txtResultadoFinal.text = "Te fuiste"
                txtResultadoFinal.visibility = View.VISIBLE
                txtResultadoFinal.setTextColor(
                    txtResultadoFinal.getContext().getResources().getColor(R.color.colorPrimary)
                )
            }


            jugarBtn.setOnClickListener {

                if (1 == 1) {

                    if (vidas > 1) {
                        if (numeroSecreto.toString() == numeroIngresado.text.toString()) {
                            if (ayuda < 3) {
                                Toast.makeText(this, "GANASTE ", Toast.LENGTH_LONG).show()
                                txtResultadoFinal.text = "GANASTE"
                            } else {
                                Toast.makeText(
                                    this,
                                    "Ganaste con ayuda, TRAMPOSO ",
                                    Toast.LENGTH_LONG
                                ).show()
                                txtResultadoFinal.text = "GANASTE CON AYUDA"
                            }
                            vidas = vidas - 1
                            intentos = intentos + 1
                            txtOportunidades.text = "Intentos Restantes: " + vidas
                            txtIntentos.text = "Cantidad de Intentos: " + intentos
                            jugarBtn.isEnabled = false
                            AydaBtn.isEnabled = false
                            BtnFin.isEnabled = false
                            numeroIngresado.isEnabled = false
                            txtResultadoFinal.visibility = View.VISIBLE


                        } else {
                            Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
                            vidas = vidas - 1
                            intentos = intentos + 1
                            txtOportunidades.text = "Intentos Restantes: " + vidas
                            txtIntentos.text = "Cantidad de Intentos: " + intentos
                        }
                    } else {
                        Toast.makeText(this, "PERDISTE", Toast.LENGTH_LONG).show()
                        vidas = vidas - 1
                        intentos = intentos + 1
                        txtOportunidades.text = "Intentos Restantes: " + vidas
                        txtIntentos.text = "Cantidad de Intentos: " + intentos
                        //jugarBtn.isEnabled = false
                        BtnFin.isEnabled = false
                        AydaBtn.isEnabled = false
                        numeroIngresado.isEnabled = false
                        txtResultadoFinal.text = "PERDISTE"
                        txtResultadoFinal.visibility = View.VISIBLE
                        txtResultadoFinal.setTextColor(txtResultadoFinal.getContext().getResources()
                                .getColor(R.color.colorPrimary))



                    }
                    BtnContinua.setOnClickListener {
                        val intent: Intent = Intent(this, Contador::class.java)
                        startActivity(intent)
                        finish()
                    }

                } else {
                    Toast.makeText(this, "El nuemero debe ser MENOR A 100", Toast.LENGTH_LONG)
                        .show()




            }

        }
    }
}










