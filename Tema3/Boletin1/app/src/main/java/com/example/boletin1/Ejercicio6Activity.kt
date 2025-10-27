package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Ejercicio6Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Contador()

        }
    }


}

@Composable
fun Contador() {

    var numero by remember { mutableIntStateOf(0) }

    var alerta by remember { mutableStateOf("") }

    Box(

        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()

    ) {

        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(50.dp)

        ) {

            Text(text = numero.toString())

            Row(

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(30.dp)

            ) {

                Button(
                    onClick = {

                        if(numero != 10){

                            numero++
                            alerta = ""

                        } else {

                            alerta = "El número ya está al máximo."

                        }

                    }
                ) {
                    Text(text = "Sumar")
                }

                Button(
                    onClick = {
                        if(numero != 0){

                            numero--
                            alerta = ""

                        } else {

                            alerta = "El número ya está al mínimo."

                        }
                    }
                ) {
                    Text(text = "Restar")
                }

            }

            Button(
                onClick = {
                    numero = 0
                }
            ) {
                Text(text = "Reiniciar")
            }

            Text(text = alerta)

        }

    }

}