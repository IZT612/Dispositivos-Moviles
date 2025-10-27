package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Ejercicio7Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CambiarTamaño()

        }
    }
}

@Composable
fun CambiarTamaño() {

    var tamaño by remember { mutableStateOf(20.sp) }


    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {

        Text(

            text = "Este texto cambia de tamaño.",
            fontSize = tamaño

        )

        Row(

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(20.dp)

        ) {

            Button(

                onClick = {

                    tamaño = (tamaño.value + 1).sp

                }

            ) {

                Text(text = "Aumentar tamaño.")

            }

            Button(

                onClick = {
                    tamaño = (tamaño.value - 1).sp
                }

            ) {

                Text(text = "Reducir tamaño.")

            }

        }



    }



}