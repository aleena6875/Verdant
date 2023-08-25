package com.example.task1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.model.Result1
import com.example.task1.retrofit.QuoteApiInterface
import com.example.task1.retrofit.QuoteRetrofit
import kotlinx.coroutines.launch

class VehicleViewModel:ViewModel (){
    val response1=MutableLiveData<List<Result1>>()
    val api1=QuoteRetrofit().getVehicleInstance().create(QuoteApiInterface::class.java)
fun getVehicleDatas()
{
        viewModelScope.launch {
            val res = api1.getVehicleData()
            response1.value = res.body()?.Results
        }
    }
}