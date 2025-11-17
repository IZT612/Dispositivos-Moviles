package com.example.simulacro_loteria.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "seleccionar/" + 10
    ) {

        composable("seleccionar/{saldo}",
            arguments = listOf(navArgument("saldo") {type = NavType.IntType}))
        {
            backStackEntry -> val saldo = backStackEntry.arguments?.getInt("saldo") ?: 10

            seleccionarNumero(9, 3, saldo, navController)
        }

        composable(
            "apostar/{numeroApostado}/{saldo}",
            arguments = listOf(
                navArgument("numeroApostado") {type = NavType.IntType},
                navArgument("saldo") {type = NavType.IntType})
        ){
            backStackEntry ->
            val numeroApostado = backStackEntry.arguments?.getInt("numeroApostado")
            val saldo = backStackEntry.arguments?.getInt("saldo") ?: 10

            apuesta(saldo, numeroApostado ,navController)
        }

        composable(
            route = "resultado/{numeroApostado}/{cantidadApostada}/{saldo}",
            arguments = listOf(
                navArgument("numeroApostado") {
                    type = NavType.IntType
                },
                navArgument("cantidadApostada") {
                    type = NavType.IntType
                },
                navArgument("saldo") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val numeroApostado = backStackEntry.arguments?.getInt("numeroApostado")?: 0
            val cantidadApostada = backStackEntry.arguments?.getInt("cantidadApostada")?: 0
            val saldo = backStackEntry.arguments?.getInt("saldo")?: 0

            resultado(numeroApostado, cantidadApostada, saldo, navController)
        }

        /* composable(
        "detalle/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id")
        DetalleScreen(id)
    } */

    }

}

/* Composable para la primera View, aunque ahora pida solo 9 numeros, con los parametros podemos hacerlo de cuantos
queramos*/
@Composable
fun seleccionarNumero(numeros: Int, numerosPorFila: Int, saldo: Int, navController: NavController) {

    var filaActual = 1;

    var numerosPorFilaActuales = 1;

    val filas = if (numeros % numerosPorFila == 0) {

         numeros / numerosPorFila

    } else {

        (numeros / numerosPorFila) + 1

    }

    var numeroActual = 1;

    Column(

        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Text(text = "¡Seleccione un número!")

        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)

        ) {

            while(filaActual <= filas) {

                Row() {

                    while(numeroActual <= numeros && numerosPorFilaActuales <= numerosPorFila) {

                        val numeroDelBoton = numeroActual

                        Button(

                            onClick = {

                                navController.navigate("apostar/" + numeroDelBoton + "/" + saldo)

                            }

                        ) {

                            Text(text = numeroDelBoton.toString())

                        }

                        numeroActual++;
                        numerosPorFilaActuales++;
                    }

                    numerosPorFilaActuales = 1

                }

                filaActual++;

            }

        }

    }

}

@Composable
fun apuesta(saldo: Int, numeroApostado: Int?, navController: NavController) {

    var cantidad by remember { mutableStateOf("0") }
    var mensajeError by remember {mutableStateOf("")}

    Column(

        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Text(text = "Tu saldo: " + saldo + " créditos")

        Text(text = "Número apostado: " + numeroApostado)

        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = cantidad,
            onValueChange = {cantidad = it},
            label = {Text (text= "Cantidad a apostar") }
        )


        Button(

            onClick = {

                if (cantidad.toInt() > saldo) {

                    mensajeError = "La cantidad es mayor a tu saldo."

                } else {

                    navController.navigate("resultado/" + numeroApostado + "/" + cantidad.toInt() + "/" + saldo)

                }

            }

        ) {

            Text(text = "Apostar")

        }

        Text(color = Color.Red, text = mensajeError)

    }

}

@Composable
fun resultado(numeroApostado: Int, cantidadApostada: Int, saldo: Int, navController: NavController) {

    val numeroResultado: Int =(1..9).random()

    var saldoActual: Int

    var resultado: String

    if(numeroApostado == numeroResultado) {

        saldoActual = saldo + cantidadApostada
        resultado = "¡Has ganado!"

    } else {

        saldoActual = saldo - cantidadApostada
        resultado = "Has Perdido..."

    }

    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(text = "Resultado: " + numeroResultado.toString())

        Text(text = resultado)

        Text(text = "Saldo actual: " + saldoActual)

        Row() {

            Button(

                onClick = {navController.navigate("seleccionar/" + saldoActual)}

            ) {

                Text(text = "Jugar de nuevo")

            }

            Button(

                onClick = {navController.navigate("seleccionar/" + 10)}

            ) {

                Text(text = "Salir")

            }


        }

    }




}


