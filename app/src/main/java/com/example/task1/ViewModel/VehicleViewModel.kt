package com.example.task1.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.Model.Result1
import com.example.task1.Retrofit.VehicleApiInterface
import com.example.task1.Retrofit.VehicleRetrofit
import kotlinx.coroutines.launch
import retrofit2.create

class VehicleViewModel:ViewModel (){
    val response1=MutableLiveData<List<Result1>>()
    val api1=VehicleRetrofit().getVehicleInstance().create(VehicleApiInterface::class.java)
fun getVehicleDatas()
{
    try {
        viewModelScope.launch {
            var res = api1.getVehicleData()
            response1.value = res.body()?.Results
        }
    }
        catch(e:Exception){
            println(e.message)
        }

}
}