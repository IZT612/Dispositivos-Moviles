package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Ejercicio3Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FrasesAleatorias()

        }
    }

}

@Composable
fun FrasesAleatorias() {

    var texto by remember { mutableStateOf("Aquí habrán frases aleatorias.") }

    Box(

        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Text(

            text = texto,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold

        )

        Button(

            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 200.dp),
            onClick = {

                texto = frasesRandom()

            }

        ) {

            Text(text = "Cambiar frase")

        }

    }

}

fun frasesRandom() : String {

    val frases = listOf("Sigue adelante", "Nunca te rindas", "El código es poesía", "Aprende algo nuevo hoy")

    return frases.random()

}