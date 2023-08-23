package com.example.task1.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteRetrofit {
    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://ron-swanson-quotes.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}