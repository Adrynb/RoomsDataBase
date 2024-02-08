package com.example.roomsdatabase.coords

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Route")
data class Coords(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var routeId: Long,
    var latitude: Double,
    var longitude: Double,
    var altitude: Double,
    var description: String
) {

}