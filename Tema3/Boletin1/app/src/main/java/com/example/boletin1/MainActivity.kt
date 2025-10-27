package com.example.boletin1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val contexto = LocalContext.current

             Column (
                 modifier = Modifier.fillMaxSize(),
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Center
             ) {
                 Button(
                     onClick = {

                         val ejercicio1Intent = Intent(contexto, Ejercicio1Activity::class.java)
                         contexto.startActivity(ejercicio1Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 1")
                 }

                 Button(
                     onClick = {

                         val ejercicio2Intent = Intent(contexto, Ejercicio2Activity::class.java)
                         contexto.startActivity(ejercicio2Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 2")
                 }

                 Button(
                     onClick = {

                         val ejercicio3Intent = Intent(contexto, Ejercicio3Activity::class.java)
                         contexto.startActivity(ejercicio3Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 3")
                 }

                 Button(
                     onClick = {

                         val ejercicio4Intent = Intent(contexto, Ejercicio4Activity::class.java)
                         contexto.startActivity(ejercicio4Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 4")
                 }

                 Button(
                     onClick = {

                         val ejercicio5Intent = Intent(contexto, Ejercicio5Activity::class.java)
                         contexto.startActivity(ejercicio5Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 5")
                 }

                 Button(
                     onClick = {

                         val ejercicio6Intent = Intent(contexto, Ejercicio6Activity::class.java)
                         contexto.startActivity(ejercicio6Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 6")
                 }

                 Button(
                     onClick = {

                         val ejercicio7Intent = Intent(contexto, Ejercicio7Activity::class.java)
                         contexto.startActivity(ejercicio7Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 7")
                 }

                 Button(
                     onClick = {

                         val ejercicio8Intent = Intent(contexto, Ejercicio8Activity::class.java)
                         contexto.startActivity(ejercicio8Intent)
                     }
                 ) {
                     Text(text = "Ejercicio 8")
                 }

             }

        }
    }
}