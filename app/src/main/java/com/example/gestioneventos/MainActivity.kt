package com.example.gestioneventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gestioneventos.ui.theme.GestionEventosTheme

open class Entrada(val id: Int, val precio: Double) {

    open fun mostrarDetalle() {
        println("Id: $id, Precio: $precio")
    }

}

class EntradaGeneral(id: Int, precio: Double) : Entrada(id, precio) {
    override fun mostrarDetalle() {
        println("[Entrada General] ID: $id | Precio: $$precio | Acceso Estándar")
    }
}

class EntradaVIP(id: Int, precio: Double, val beneficiosExtra: String) : Entrada(id, precio) {
    override fun mostrarDetalle() {
        println("[Entrada VIP] ID: $id | Precio: $$precio | Beneficios: $beneficiosExtra")
    }
}

fun main() {
    val listaEntradas: List<Entrada> = listOf(
        EntradaGeneral(id = 1, precio = 25000.0),
        EntradaVIP(id = 2, precio = 60000.0, beneficiosExtra = "Acceso a Lounge + Bebida de cortesía"),
        EntradaGeneral(id = 3, precio = 25000.0),
        EntradaVIP(id = 4, precio = 75000.0, beneficiosExtra = "Meet & Greet + Estacionamiento Preferencial"),
        EntradaGeneral(id = 5, precio = 30000.0),
        EntradaVIP(id = 6, precio = 60000.0, beneficiosExtra = "Acceso a Lounge")
    )

    println("=== DETALLE DE ENTRADAS VENDIDAS ===")
    listaEntradas.forEach { entrada ->
        entrada.mostrarDetalle()
    }

    println("\n=== ANÁLISIS DE DATOS DE LA COLECCIÓN ===")

    val ingresoTotal = listaEntradas.sumOf { it.precio }
    println("Ingreso Total Generado: $$ingresoTotal")

    val cantidadVIP = listaEntradas.count { it is EntradaVIP }
    println("Cantidad de Entradas VIP Vendidas: $cantidadVIP")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestionEventosTheme {
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GestionEventosTheme {
        Greeting("Android")
    }
}