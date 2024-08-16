package com.example.tercer

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.tercer.models.Productos

class MainActivity : AppCompatActivity() {
    lateinit var btnCal:Button
    lateinit var  txtprecio:EditText
    lateinit var  tvResult: TextView
    lateinit var  spList:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //codigo
        cargarR()
        estadoBoton()


        val listaPaises= arrayOf("USA","BOL","ESP")
        val listaIVAadapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listaPaises)
        spList.adapter=listaIVAadapter

    }
    //funciom para cargar r
    fun  cargarR (){
        btnCal= findViewById(R.id.btnCalcular)
        txtprecio =findViewById(R.id.txtPrecio)
        tvResult = findViewById(R.id.tvResultado)
        spList = findViewById(R.id.spListaPaises)
    }

    //estados de boton
    fun estadoBoton(){
        btnCal.setOnClickListener(){
            val precio:Double = txtprecio.text.toString().toDouble()
            val laptop=Productos("laptop",precio)
            when(spList.selectedItem.toString()){
                "USA" ->tvResult.text=laptop.calcularIVA(0.03).toString()
                "BOL" ->tvResult.text=laptop.calcularIVA(0.13).toString()
                "ESP" ->tvResult.text=laptop.calcularIVA(0.05).toString()

            }


        }
    }
}