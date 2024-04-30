package com.example.ejercisio9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {

    lateinit var edUsuario: EditText
    lateinit var edPassword:EditText
    lateinit var edPassword2:EditText
    lateinit var edNombre:EditText
    lateinit var edCarrera:EditText
    lateinit var edTelefono:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        edUsuario = findViewById(R.id.edUsuario)
        edPassword = findViewById(R.id.edPassword)
        edPassword2 = findViewById(R.id.edPassword2)
        edNombre = findViewById(R.id.edNombre)
        edCarrera = findViewById(R.id.edCarrera)
        edTelefono = findViewById(R.id.edTelefono)
    }
    fun guardar(v:View){
        val usuario = edUsuario.text.toString()
        val password = edPassword.text.toString()
        val password2 = edPassword2.text.toString()
        val nombre = edNombre.text.toString()
        val carrera = edCarrera.text.toString()
        val telefono = edTelefono.text.toString()

        Log.w("Ejercisio 9", "Todos mis datos estan correctos")

        val preferencia = getSharedPreferences("misdatos", Context.MODE_PRIVATE)
        val editor = preferencia.edit()

        editor.putString("usuario", usuario)
        editor.putString("password", password)
        editor.putString("password2", password2)
        editor.putString("nombre", nombre)
        editor.putString("carrera", carrera)
        editor.putString("telefono", telefono)
        editor.putBoolean("sesion", false)

        editor.commit()
        Toast.makeText(this, "Se guardo el usuario", Toast.LENGTH_LONG).show()

        finish()
}

}