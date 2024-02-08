package com.example.roomsdatabase.Routes

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomsdatabase.Coords.Coordinate
import com.example.roomsdatabase.Coords.CoordinateDao
import com.example.roomsdatabase.GPSDatabase

class RouteRepository(private var context: Context) {

    private lateinit var routeDao : RouteDao
    private lateinit var coordDao : CoordinateDao

    fun delete (item : Route){
        this.routeDao.delete(item)
    }

    fun insert(item:Route){
        this.routeDao.insert(item)
    }

    fun update(item: Route) {
        this.routeDao.update(item)
    }

    fun getAllRoutes(): MutableList<Route> {
        return routeDao.getAllRoutes().toMutableList()
    }

    fun save(selected:Route):Long?{
        if(selected.id==null){
            selected.id=this.routeDao.insert(selected)
            return selected.id
        }else{
            this.routeDao.update(selected)
            return selected.id
        }
    }

    fun getCoordinatesForRoute(routeId: Long): LiveData<List<Coordinate>> {
        return coordDao.getCoordinatesForRoute(routeId)
    }

     fun insertCoordinate(coordinate: Coordinate): Long {
        return coordDao.insertCoordinate(coordinate)
    }

     fun updateCoordinate(coordinate: Coordinate) {
        coordDao.updateCoordinate(coordinate)
    }

     fun deleteCoordinate(coordinate: Coordinate) {
        coordDao.deleteCoordinate(coordinate)
    }


    fun init(context: Context) {
        if (!::routeDao.isInitialized) {
            val database = GPSDatabase.getInstance(context)
            routeDao = database.routeDao()
        }
    }
}

