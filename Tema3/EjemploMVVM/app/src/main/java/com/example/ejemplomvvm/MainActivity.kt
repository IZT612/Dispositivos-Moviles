package com.example.ejemplomvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ejemplomvvm.models.UserVM
import com.example.ejemplomvvm.ui.UserListScreen
import com.example.ejemplomvvm.ui.theme.EjemploMVVMTheme

class MainActivity : ComponentActivity() {
    // ViewModel compartido para toda la actividad
    private val userViewModel: UserVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            EjemploMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    UserListScreen(userViewModel = userViewModel)
                }
            }
        }
    }
}


