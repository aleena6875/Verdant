package com.example.task1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task1.R
import com.example.task1.view.fragments.Frag1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Frag1())
            .commit()
    }
    }
