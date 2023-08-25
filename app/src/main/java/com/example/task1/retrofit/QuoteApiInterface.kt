package com.example.task1.retrofit

import com.example.task1.model.Vehicle
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiInterface {
    @GET("/v2/quotes")
    suspend fun getRandomQuote():Response<List<String>>
    @GET("api/vehicles/getallmanufacturers?format=json")
    suspend fun getVehicleData():Response<Vehicle>
}