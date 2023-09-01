package com.example.task1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class LoginData (val username:String, val password: String)
 data class LoginResponse(val username :String,val token:String,val password:String,val id:Int,val email:String,val firstName:String,val lastName: String,val gender:String,val image:String)

