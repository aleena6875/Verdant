package com.example.task1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task1.R
import com.example.task1.view.fragments.LoginFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.beginTransaction().replace(R.id.login_container,LoginFragment()).commit()
    }
}