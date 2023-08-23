package com.example.task1.Retrofit

import com.example.task1.Model.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiInterface {
    @GET("/v2/quotes")
    suspend fun getRandomQuote():Response<List<String>>
}