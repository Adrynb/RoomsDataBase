package com.example.roomsdatabase.Routes

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.*

@Dao
interface RouteDao {

    @Insert
     fun insert(route: Route): Long

    @Delete
     fun delete(route: Route)

    @Update
     fun update(route: Route)

    @Query("SELECT * FROM route")
    fun getAllRoutes(): List<Route>

    @Query("SELECT * FROM route WHERE id = :routeId")
    fun getCoordinatesForRoute(routeId: Long): RouteWithCoords
}
