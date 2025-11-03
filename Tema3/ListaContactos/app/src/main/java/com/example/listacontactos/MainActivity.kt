package com.example.listacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.listacontactos.presentation.views.ContactsScreen
import com.example.listacontactos.presentation.views.Nav
import com.example.listacontactos.ui.theme.ListaContactosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaContactosTheme {

                val modifier: Modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)

                Nav()

            }
        }
    }
}
