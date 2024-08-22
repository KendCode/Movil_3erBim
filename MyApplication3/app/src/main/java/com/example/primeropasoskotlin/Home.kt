package com.example.primeropasoskotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    lateinit var carProducto:CardView
    lateinit var carIva:CardView
    lateinit var carSalir:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoBoton()
    }

    fun cargarR (){
        carProducto = findViewById(R.id.cardProducto)
        carIva = findViewById(R.id.cardIva)
        carSalir = findViewById(R.id.cardSalida)
    }

    fun estadoBoton(){
        carIva.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        carProducto.setOnClickListener{
            val f = Intent(this,Productos::class.java)
            startActivity(f)
        }


    }
}