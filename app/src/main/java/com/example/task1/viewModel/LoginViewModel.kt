package com.example.task1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.model.LoginData
import com.example.task1.model.LoginResponse
import com.example.task1.retrofit.QuoteApiInterface
import com.example.task1.retrofit.QuoteRetrofit
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val response2= MutableLiveData<Boolean>()
    val userResponse=MutableLiveData<LoginResponse>()
    val api2= QuoteRetrofit().getLoginInstance().create(QuoteApiInterface::class.java)
    fun logAuth(username:String,password:String)
    {
val loginData=LoginData(username, password)
        viewModelScope.launch {
            try {
                val res=api2.getLoginData(loginData)
                   response2.value=res.isSuccessful
                userResponse.value=res.body()
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }


}