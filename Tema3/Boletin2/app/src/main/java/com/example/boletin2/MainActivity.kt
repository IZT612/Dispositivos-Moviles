package com.example.boletin2

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.boletin2.data.repositories.DestinosRepository
import com.example.boletin2.domain.entities.Destino
import com.example.boletin2.ui.theme.Boletin2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Nav()

        }
    }
}

@Composable
fun Nav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "ej1Destinos"
    ) {

        composable("ej1Destinos") {

            ej1Destinos(navController)
        }

        composable(
            "ej1Detalles/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            ej1Detalles(navController, id)
        }

    }

}

@Composable
fun ej1Destinos(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        items(DestinosRepository.obtenerLista()) { itemDestino ->
            Row(

                modifier = Modifier.clickable{

                    navController.navigate("ej1Detalles/${itemDestino.id}")

                }

            ) {

                Text(itemDestino.name)

                Text(itemDestino.pais)

            }

        }
        }
}

@Composable
fun ej1Detalles(navController: NavController, id: Int?) {

    val destino: Destino = DestinosRepository.obtenerPorId(id?: 0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Nombre: " + destino.name)
        Text(text = "País: " + destino.pais)
        Text(text = "ID: " + destino.id)
    }

}


