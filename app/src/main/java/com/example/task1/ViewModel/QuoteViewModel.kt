package com.example.task1.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.Model.Quotes
import com.example.task1.Retrofit.QuoteApiInterface
import com.example.task1.Retrofit.QuoteRetrofit
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create

class QuoteViewModel: ViewModel() {
    val response=MutableLiveData<List<String>>()
    val api=QuoteRetrofit().getInstance().create(QuoteApiInterface::class.java)
    fun getRandomQuotes(){
        try{
        viewModelScope.launch {
           var res=api.getRandomQuote()
            response.value=res.body()
        }
    }catch (e:Exception){
    println(e.message)
        }    }
}