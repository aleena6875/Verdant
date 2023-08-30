package com.example.task1.model

data class LoginData (val username:String,val password: String)
data class LoginResponse(val username :String,val token:String,val password:String)
