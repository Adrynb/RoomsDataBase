package com.example.roomsdatabase.Routes

import android.content.Context
import com.example.roomsdatabase.GPSDatabase

class RouteRepository(private var context: Context) {

    private lateinit var routeDao : RouteDao

    fun delete (item: Route){
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

    fun getCoordinatesForRoute(routeId: Long): RouteWithCoords {
        return this.routeDao.getCoordinatesForRoute(routeId)
    }


    fun init(context: Context) {
        if (!::routeDao.isInitialized) {
            val database = GPSDatabase.getInstance(context)
            routeDao = database.routeDao()
        }
    }
}

