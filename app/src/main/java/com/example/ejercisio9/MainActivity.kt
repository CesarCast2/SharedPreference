package com.example.ejercisio9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val preferencias = getSharedPreferences("misdatos", Context.MODE_PRIVATE)

        val txtViewNombre = findViewById<TextView>(R.id.txtNombre)
        val txtViewCarrera = findViewById<TextView>(R.id.txtCarrera)
        val txtViewTelefono = findViewById<TextView>(R.id.txtTelefono)

        txtViewNombre.text = preferencias.getString("nombre", "XXX")
        txtViewCarrera.text = preferencias.getString("carrera", "XXX")
        txtViewTelefono.text = preferencias.getString("telefono", "XXX")
    }

}