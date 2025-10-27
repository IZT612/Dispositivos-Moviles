package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class Ejercicio2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()

            ) {

                Tarjeta()

            }

        }
    }

}

@Composable
fun Tarjeta() {

    Card (

        modifier = Modifier
            .width(250.dp)
            .height(200.dp)

    ){

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ){

            Text(

                text = "Iván Zamora Torres",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )

            Text(

                text = "Estudiante"

            )

            Text(

                text = "ivan.zamora@iesnervion.es",
                fontWeight = FontWeight.SemiBold

            )


        }

    }

}
