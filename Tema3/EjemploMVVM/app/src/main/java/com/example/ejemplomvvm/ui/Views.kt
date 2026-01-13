package com.example.ejemplomvvm.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ejemplomvvm.models.User
import com.example.ejemplomvvm.models.UserVM
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserListScreen(
    userViewModel: UserVM = viewModel()
) {
    val userList by userViewModel.users

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val newUser = User(
                    id = userList.size + 1,
                    name = "Nuevo Usuario ${userList.size + 1}"
                )
                userViewModel.insertUser(newUser)
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Añadir Usuario")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(userList) { user ->
                UserRow(user = user)
            }
        }
    }
}

@Composable
fun UserRow(user: User) {



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = user.id.toString(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = user.name)
    }
    Divider()
}






