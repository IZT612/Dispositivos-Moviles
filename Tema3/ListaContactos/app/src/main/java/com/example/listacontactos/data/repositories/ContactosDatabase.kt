package com.example.listacontactos.data.repositories

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.listacontactos.domain.entities.Contacto

@Database(
    entities = [Contacto::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(GeneroConverter::class)
abstract class ContactosDatabase : RoomDatabase() {
    abstract fun contactosDao(): ContactosDao
}