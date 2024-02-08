package com.example.roomsdatabase.routes

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RouteViewModel() : ViewModel() {

    private lateinit var _context: Context
    lateinit var routeRepository: RouteRepository
    private lateinit var _routes: MutableLiveData<MutableList<Route>>

    var selectedRoute = Route()


    public val routes: LiveData<MutableList<Route>>
        get() = _routes

    fun init(C: Context) {
        this._context = C
        _routes = MutableLiveData()
        this.routeRepository = RouteRepository(C)
        this._routes.value = this.routeRepository.getAllRoutes()
    }

    fun getRouteWithCoords(): RouteWithCoords? {
        return this.selectedRoute.id?.let { this.routeRepository.getCoordinatesForRoute(it) }
    }

    fun save() {

        if(this.selectedRoute.id == null){
            this._routes.value?.add(this.selectedRoute)
            this.routeRepository.save(this.selectedRoute)
            var saveRoute = this.selectedRoute
            this.update()

        }

        this.routeRepository.save(this.selectedRoute)

    }


    fun update() {
        var values = this._routes.value
        this._routes.value = values
    }

    fun delete() {

        this._routes.value?.remove(this.selectedRoute)
        this.routeRepository.delete(this.selectedRoute)
    }


}
