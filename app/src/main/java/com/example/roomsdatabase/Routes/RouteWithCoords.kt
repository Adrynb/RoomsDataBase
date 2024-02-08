package com.example.roomsdatabase.Routes

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.roomsdatabase.Coords.Coords

@Entity
data class RouteWithCoords(
    @Embedded val route : Route,
    @Relation(
        parentColumn = "id",
        entityColumn = "routeID"
    )
    val coords : List<Coords>
)
