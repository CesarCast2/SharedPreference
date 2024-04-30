package com.example.ejercisio9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    var usuario = ""
    var pass = ""
    var sesion = false
    val usuarioProvisional = "Cesar"
    val PasswordProvisional = "1234"
    lateinit var edUsuario: EditText
    lateinit var edPassword: EditText
    lateinit var txtInpuUsuario: TextInputLayout
    lateinit var txtInputPassword: TextInputLayout


    fun registrarNuevo(view: View){
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }



    fun autentificar(v: View) {
        val usuario = edUsuario.text.toString()
        val password = edPassword.text.toString()
        //Aqui se tiene que validar que el usuario y el password no vengan vacios




        //si viene vacio el campo ususario
        txtInpuUsuario.error = "No puede ir vacio el campo"
        Toast.makeText(this, "no puede ir vacio el campo usuario", Toast.LENGTH_LONG).show()
        //Esta comparacion es provisional
        if (!this.usuario.equals("XXX") && usuario.equals(this.usuario) && password.equals(pass)) {
            //se autentifica
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            txtInpuUsuario.error = "Usuario incorrecto"
            txtInputPassword.error = "Password Incorrecto"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val preferencia = getSharedPreferences("misdatos", Context.MODE_PRIVATE)
        usuario = preferencia.getString("usuario", "XXX").toString()
        pass = preferencia.getString("password", "XXX").toString()
        sesion = preferencia.getBoolean("sesion", false)

        edUsuario = findViewById(R.id.edUsuario)
        edPassword = findViewById(R.id.edPassword)
        txtInpuUsuario = findViewById(R.id.txtInputUsuario)
        txtInputPassword = findViewById(R.id.txtInputPassword)
    }
}