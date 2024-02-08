package com.example.roomsdatabase.coords

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomsdatabase.routes.RouteWithCoords

@Dao
interface CoordinateDao {
    @Insert
     fun insertCoordinate(coordinate: Coords): Long

    @Update
     fun updateCoordinate(coordinate: Coords)

    @Delete
     fun deleteCoordinate(coordinate: Coords)

    @Query("SELECT * FROM routewithcoords WHERE id = :routeId")
    fun getCoordinatesForRoute(routeId: Long): RouteWithCoords
}