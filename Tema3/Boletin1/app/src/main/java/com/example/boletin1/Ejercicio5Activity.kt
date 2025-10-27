package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource

class Ejercicio5Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                Tarjeta2()

            }


        }
    }

}

@Composable
fun Tarjeta2() {

    var mostrar by remember { mutableStateOf(true) }

    var texto by remember { mutableStateOf("Ver menos") }

    AnimatedVisibility(
        visible = mostrar
    ) {

        Card(

            modifier = Modifier
                .width(250.dp)
                .height(200.dp)

        ) {

            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {

                Text(

                    text = "Iván Zamora Torres",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold

                )

                Text(

                    text = "Estudiante"

                )

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // tu imagen en drawable
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)

                )

            }

        }

    }

    Button(

        onClick = {

            if(mostrar) {

                mostrar = false
                texto = "Ver más."

            } else {

                mostrar = true
                texto = "Ver menos."

            }

        }

    ) {

        Text(text = texto)

    }

}