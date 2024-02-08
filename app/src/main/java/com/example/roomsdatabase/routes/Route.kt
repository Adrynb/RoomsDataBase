package com.example.roomsdatabase.routes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Route")
data class Route(
    var nombre: String = "",
    var descripcion: String = "",
    val estado: Boolean = false,
    var dificultad: Int = 0,
    @PrimaryKey(autoGenerate = true) var id:Long?=null
) {

}
