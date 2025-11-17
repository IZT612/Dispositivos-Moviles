package com.example.listacontactos.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listacontactos.R
import com.example.listacontactos.data.repositories.ContactosRepository
import com.example.listacontactos.domain.entities.Contacto
import com.example.listacontactos.domain.entities.Genero


@Composable
fun Nav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {

        composable("lista") { ContactsScreen(
            Modifier.fillMaxSize().padding(24.dp),
            navController
        )
        }

        composable("añadir") { Formulario(navController)
        }

    }

}

@Composable
fun ContactRow(contacto: Contacto) {

    var mostrarDatos by remember { mutableStateOf(false)}

    var iniciales = ""

    contacto.name.split(" ").forEach { hilo ->

        iniciales += hilo.substring(0, 1)

    }

    val imagenGenero = if (contacto.genero == Genero.Masculino) {
        R.drawable.masculino
    } else {
        R.drawable.femenino
    }



    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(
                painter = painterResource(id = imagenGenero),
                contentDescription = "Foto contacto",
                Modifier
                    .height(100.dp)
                    .clickable(true, onClick = {

                        if (!mostrarDatos) {

                            mostrarDatos = true

                        } else {

                            mostrarDatos = false

                        }

                    })
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                if (!mostrarDatos) {
                    Text(
                        text = iniciales,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                if (mostrarDatos) {
                    Text(
                        text = contacto.name,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                if (mostrarDatos) {
                    Text(
                        text = contacto.phoneNumber,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                if (mostrarDatos) {
                    Text(
                        text = contacto.genero.toString(),
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ContactsScreen(modifier: Modifier, navController: NavController) {
    val lista = ContactosRepository.getAllContacts()



    Scaffold(modifier = modifier) { innerPadding ->

        LazyColumn(modifier = Modifier.padding(innerPadding)) {	// Scroll vertical,
            items(lista) { itemContacto ->
                ContactRow(contacto = itemContacto)
            }
        }

        Button(

            onClick = {navController.navigate("añadir")}

        ) {

            Text(text = "Añadir.")

        }

    }
}

@Composable
fun Formulario(navController: NavController) {

    var textNombre by remember { mutableStateOf("") }
    var textTelefono by remember { mutableStateOf("") }
    val nuevaId = ContactosRepository.getAllContacts().maxOf { it.id } + 1
    val options = listOf("Masculino", "Femenino")
    var selectedOption by remember { mutableStateOf(options[0]) }
    var genero: Genero


    Column (

        modifier = Modifier.fillMaxSize().padding(30.dp)

    )
    {

        TextField(
            value = textNombre,
            onValueChange = { textNombre = it },
            label = { Text("Nombre") }
        )

        TextField(
            value = textTelefono,
            onValueChange = { textTelefono = it },
            label = { Text("Teléfono") }
        )

        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedOption = option }
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { selectedOption = option }
                )
                Text(
                    text = option,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Button(

            onClick = {

                if (selectedOption.equals("Masculino")) {

                    genero = Genero.Masculino

                } else {

                    genero = Genero.Femenino

                }

                val nuevoContacto: Contacto = Contacto(nuevaId, textNombre, textTelefono, genero)

                ContactosRepository.guardarContacto(nuevoContacto)

                navController.navigate("lista")

            }

        ) {

            Text(text = "Guardar")

        }

    }

}


