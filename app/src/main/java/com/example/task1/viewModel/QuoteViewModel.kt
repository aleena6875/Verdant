package com.example.task1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.retrofit.QuoteApiInterface
import com.example.task1.retrofit.QuoteRetrofit
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val response=MutableLiveData<String>()
    val api=QuoteRetrofit().getInstance().create(QuoteApiInterface::class.java)
    fun getRandomQuotes(){
        viewModelScope.launch {
           val res=api.getRandomQuote()
            response.value=res.body()?.first()
        }
       }
}