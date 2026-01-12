package com.example.listacontactos.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacto_entidad")
data class Contacto(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String = "",
    val phoneNumber: String = "",
    val genero: Genero = Genero.Masculino
)

enum class Genero {
    Masculino,
    Femenino
}
