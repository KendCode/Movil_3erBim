package com.example.iva.models

class Productos constructor(nombre:String, precio:Double){
    var nombre:String = nombre
    var precio:Double = precio

    fun calcularIVA(iva: Double):Double{
        var total:Double = precio*iva
        total = total + precio
        return total
    }
}