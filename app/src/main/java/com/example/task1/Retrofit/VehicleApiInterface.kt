package com.example.task1.Retrofit

import com.example.task1.Model.Vehicle
import retrofit2.Response
import retrofit2.http.GET

interface VehicleApiInterface {
    @GET("api/vehicles/getallmanufacturers?format=json")
    suspend fun getVehicleData():Response<Vehicle>
}