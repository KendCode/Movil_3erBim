package com.example.iva

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.iva.models.Productos


class MainActivity : AppCompatActivity(){

    lateinit var btnCal: Button
    lateinit var txtPrecio: EditText
    lateinit var txtNombre: EditText
    lateinit var tvResult: TextView
    lateinit var spList: Spinner
    lateinit var listPro: ListView

    lateinit var listaProductosMutables:MutableList<String>
    lateinit var arrayAdapterProductos:ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoButon()
        cargarLista()

        val listaPaises= arrayOf("USA","BOL","ESP")
        val ListaIVAAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listaPaises)
        //spList.adapter = listaIVAadapter
        spList.adapter = ListaIVAAdapter
    }
    //funcion para cargar R
    fun cargarR (){
        btnCal = findViewById(R.id.btnCalcular)
        txtNombre = findViewById(R.id.txtNombre)
        txtPrecio = findViewById(R.id.txtPrecio)
        tvResult = findViewById(R.id.tvResultado)
        spList = findViewById(R.id.splistaPaises)
        listPro = findViewById(R.id.listProducto)
    }
    fun estadoButon(){
        btnCal.setOnClickListener(){

            var precio: Double = txtPrecio.text.toString().toDouble()
            val laptop = Productos(txtNombre.text.toString(), precio)//txtNom.text.toStrin(),precio
            val totalConIVA: Double
            when(spList.selectedItem.toString()){
                "USA" -> listaProductosMutables.add(laptop.nombre+", "+laptop.calcularIVA(0.03))//laptop.nombre+","+laptop.calcularIVA......
                "BOL" -> listaProductosMutables.add(laptop.nombre+", "+laptop.calcularIVA(0.13))
                "ESP" -> listaProductosMutables.add(laptop.nombre+", "+laptop.calcularIVA(0.05))
                else -> listaProductosMutables.add(laptop.nombre+", "+laptop.calcularIVA(0.0))
            }
            listPro.adapter = arrayAdapterProductos
            //tvResult.text = "Producto: $nombre\nTotal con IVA: $totalConIVA"
            //Toast.makeText(, "hola mundo", Toast.LENGTH_SHORT).show()
            //tvResult.setText(laptop.calcularIVA().toString())

        }
    }
    fun cargarLista(){
        //var listaArrayProductos = arrayOf("laptop","computadora")
        listaProductosMutables = mutableListOf("3500")
        arrayAdapterProductos = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listaProductosMutables)
        listPro.adapter = arrayAdapterProductos
    }

}