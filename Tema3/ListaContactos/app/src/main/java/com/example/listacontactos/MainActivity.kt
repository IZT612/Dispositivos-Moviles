package com.example.listacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.listacontactos.data.repositories.ContactosDatabase
import com.example.listacontactos.presentation.views.Nav
import com.example.listacontactos.ui.theme.ListaContactosTheme

class MainActivity : ComponentActivity() {
    companion object {
        lateinit var database: ContactosDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        database = Room.databaseBuilder(
            applicationContext,
            ContactosDatabase::class.java,
            "contactos-db"
        ).build()

        setContent {
            ListaContactosTheme {
                Nav()
            }
        }
    }
}
