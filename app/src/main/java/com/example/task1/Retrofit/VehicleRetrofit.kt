package com.example.task1.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VehicleRetrofit {
    fun getVehicleInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://vpic.nhtsa.dot.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}