package com.example.task1.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.task1.R
import com.example.task1.model.LoginResponse
import com.example.task1.model.setImage
import com.google.gson.Gson


class Frag3Profile : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag3_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userDatas=retrieveDataFromSharedPreferences()
        if(userDatas!=null) {
            val nameTextView: TextView = view.findViewById(R.id.nameTextView)
            val emaiTextView: TextView = view.findViewById(R.id.emailTextView)
            val imageView:ImageView=view.findViewById(R.id.imageView)
            val fname:TextView=view.findViewById(R.id.fnameTextView)
            val lname:TextView=view.findViewById(R.id.lnameTextView)
            val gender:TextView=view.findViewById(R.id.genderTextView)
            val id:TextView=view.findViewById(R.id.idTextView)
            val iTextView:TextView=view.findViewById(R.id.iTextView)
            nameTextView.text="UserName:${userDatas.username}"
            emaiTextView.text="Email:${userDatas.email}"
            fname.text="FirstName:${userDatas.firstName}"
            lname.text="LastName:${userDatas.lastName}"
            id.text="Id:${userDatas.id}"
            gender.text="Gender:${userDatas.gender}"
                iTextView.text="ImageUrl:${userDatas.image}"
            imageView.setImage(userDatas.image)

        }
    }
    fun retrieveDataFromSharedPreferences():LoginResponse  {
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val jsonData = sharedPreferences.getString("apiData", null)
        val userData = Gson().fromJson(jsonData,LoginResponse::class.java)
        return userData
    }


    companion object {

        @JvmStatic
        fun newInstance() = Frag3Profile()
            }
    }
