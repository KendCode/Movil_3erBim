package com.example.tercer.models

class Productos constructor(nombre:String, precio:Double) {
    var nombre:String = nombre
    var precio:Double = precio

    fun calcularIVA(iva : Double):Double{
        var  total:Double = precio * iva
        return total
    }
}