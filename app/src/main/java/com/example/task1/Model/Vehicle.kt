package com.example.task1.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize data class Vehicle (val Results:List<Result1>):Parcelable
@Parcelize data class Result1(
    val Country:String,
    val Mfr_CommonName:String,
    val Mfr_ID:String,
    val Mfr_Name:String,
    val VehicleTypes:List<VehicleType>):Parcelable
@Parcelize data class VehicleType(val IsPrimary:Boolean,val Name:String):Parcelable