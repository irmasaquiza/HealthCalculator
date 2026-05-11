package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable

// remeber lo que hace es que cuando se actualice la pantalla guarde el valor
// mutableStatfeOf sea reactiva la pantalla cambie con la insertar valor

fun Greeting(name: String, modifier: Modifier = Modifier) {
    var pesoUsuario by remember { mutableStateOf("") }
    var alturaUsuario by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val funcionHealthEngine = HealthEngine()

Column {
    TextField(
        value = pesoUsuario,
        onValueChange = { pesoUsuario = it },
        label = { Text("Peso") }
    )

    TextField(
        value = alturaUsuario,
        onValueChange = { alturaUsuario = it },
        label = { Text("Altura") }
    )

Button(onClick = {
    val peso  = pesoUsuario.toDoubleOrNull() ?: 0.0
    val altura = alturaUsuario.toDoubleOrNull() ?: 0.0
    resultado = funcionHealthEngine.clasificarIMC(peso,altura)



}){ Text("IMC")}
    Text(text = resultado)
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}