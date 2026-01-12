package com.example.listacontactos.data.repositories

import androidx.room.TypeConverter
import com.example.listacontactos.domain.entities.Genero

class GeneroConverter {

    @TypeConverter
    fun fromGenero(genero: Genero): String {
        return genero.name
    }

    @TypeConverter
    fun toGenero(value: String): Genero {
        return Genero.valueOf(value)
    }
}