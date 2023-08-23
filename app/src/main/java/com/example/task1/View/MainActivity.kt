package com.example.task1.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.example.task1.R
import com.example.task1.View.Fragments.Frag1
import com.example.task1.View.Fragments.SplashFrag
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SplashFrag())
            .commit()
        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Frag1())
                .commit()
        }, 3000)
    }
}