package com.example.appsosa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*

enum class ProviderType{
    BASIC,
    GOOGLE
}
class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        //Setup

        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?:"", provider ?:"")

        //Guardado de datos

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()
    }

    private fun setup(email: String, provider: String){

        title = "Registro"
        emailTextView.text = email
        provideTextView.text = provider

        jugarBtn.setOnClickListener {

            //Borrado de datos

            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()


            FirebaseAuth.getInstance().signOut()
            //onBackPressed()
            val intent: Intent = Intent(this, Perfil::class.java)
            startActivity(intent)
            finish()

            }

        }
    }
