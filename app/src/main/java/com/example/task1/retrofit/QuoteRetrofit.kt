package com.example.task1.retrofit

import com.example.task1.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class QuoteRetrofit {
    companion object{
        lateinit var api2:QuoteApiInterface
    }
    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.QUOTE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getVehicleInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.VEHICLE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getLoginInstance():Retrofit{
        return  Retrofit.Builder()
            .baseUrl(Constants.LOGIN_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api2=QuoteRetrofit().getLoginInstance().create(QuoteApiInterface::class.java)

    }
}