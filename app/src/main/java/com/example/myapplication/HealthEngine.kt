package com.example.myapplication

class HealthEngine {
fun clasificarIMC(peso:Double, altura:Double):String{
val imc = peso/(altura * altura)
    return when {
        imc < 18.5 -> "Bajo Peso"
        imc in 18.5..24.9 -> "Peso normal"
        imc in 25.0 .. 29.9 -> "Sobrepeso"
        else -> "Obesidad"
    }

}

}