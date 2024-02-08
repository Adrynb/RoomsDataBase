package com.example.roomsdatabase.Routes

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsdatabase.Coords.Coordinate
import kotlinx.coroutines.launch

class RouteViewModel(private val routeRepository: RouteRepository) : ViewModel() {

    private val _allRoutes = MutableLiveData<List<Route>>()
    val allRoutes: LiveData<List<Route>> = _allRoutes

    var selectedRoute = Route()

    fun init(context: Context) {
        routeRepository.init(context)
        _allRoutes.value = routeRepository.getAllRoutes()
    }

    fun insertRoute(route: Route) {
        routeRepository.insert(route)
        _allRoutes.value = routeRepository.getAllRoutes()
    }

    fun updateRoute(route: Route) {
        routeRepository.update(route)
        _allRoutes.value = routeRepository.getAllRoutes()
    }

    fun deleteRoute(route: Route) {
        routeRepository.delete(route)
        _allRoutes.value = routeRepository.getAllRoutes()
    }

    fun getCoordinatesForRoute(routeId: Long): LiveData<List<Coordinate>> {
        return routeRepository.getCoordinatesForRoute(routeId)
    }

    fun insertCoordinate(coordinate: Coordinate) = viewModelScope.launch {
        routeRepository.insertCoordinate(coordinate)
    }

    fun updateCoordinate(coordinate: Coordinate) = viewModelScope.launch {
        routeRepository.updateCoordinate(coordinate)
    }

    fun deleteCoordinate(coordinate: Coordinate) = viewModelScope.launch {
        routeRepository.deleteCoordinate(coordinate)
    }

    fun save() {
        if (selectedRoute.id == null) {

            // Nuevo elemento, agrega a la lista y guarda en la base de datos
            selectedRoute.id = routeRepository.save(selectedRoute)

            // Obtener la lista actual
            val currentRoutes = _allRoutes.value?.toMutableList() ?: mutableListOf()

            // Agregar el nuevo elemento a la lista
            currentRoutes.add(selectedRoute)

            // Establecer el nuevo valor en _allRoutes
            _allRoutes.value = currentRoutes
        } else {
            // Actualizar elemento existente en la base de datos
            routeRepository.update(selectedRoute)
        }
    }

}

