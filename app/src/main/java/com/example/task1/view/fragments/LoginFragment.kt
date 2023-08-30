package com.example.task1.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task1.R

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.task1.view.MainActivity
import com.example.task1.viewModel.LoginViewModel


class LoginFragment : Fragment() {

lateinit var userName:EditText
lateinit var password: EditText
lateinit var loginButton:Button
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
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        with(view) {
            userName = findViewById<EditText>(R.id.login_username)
            password = findViewById<EditText>(R.id.login_password)
            loginButton = findViewById<Button>(R.id.loginButton)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginButton.setOnClickListener {
            if (nonEmptyValidation()) {
                val username = userName.text.toString()
                val password = password.text.toString()
                loginViewModel.logAuth(username, password)

            }
        }
        loginViewModel.response2.observe(viewLifecycleOwner) {res->
            if (res) {
                Toast.makeText(
                    requireContext(),
                    "Login successful",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Invalid credentials",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
       private fun nonEmptyValidation():Boolean{
            var res=false
           if (userName.text.isEmpty()&&password.text.toString().isEmpty())
           {
               Toast.makeText(
                   requireContext(),
                   "Please enter username and password",
                   Toast.LENGTH_SHORT
               ).show()
           }
           else if(userName.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Username cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if(password.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Password cannot be empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else
                res=true
            return res

        }


    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}




