package com.example.roomsdatabase.routes

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.roomsdatabase.coords.Coords

@Entity
data class RouteWithCoords(
    @Embedded val route : Route,
    @Relation(
        parentColumn = "id",
        entityColumn = "routeID"
    )
    val coords : List<Coords>
)
