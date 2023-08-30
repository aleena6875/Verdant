package com.example.task1.retrofit

import com.example.task1.model.LoginData
import com.example.task1.model.LoginResponse
import com.example.task1.model.Vehicle
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuoteApiInterface {
    @GET("/v2/quotes")
    suspend fun getRandomQuote():Response<List<String>>
    @GET("api/vehicles/getallmanufacturers?format=json")
    suspend fun getVehicleData():Response<Vehicle>
    @POST("/auth/login")
    suspend fun getLoginData(@Body loginData: LoginData):Response<LoginResponse>
}