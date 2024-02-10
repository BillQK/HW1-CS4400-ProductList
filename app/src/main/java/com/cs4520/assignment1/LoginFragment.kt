package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize views
        val usernameEditText = view.findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val loginButton = view.findViewById<Button>(R.id.loginButton)

        // Set click listener for the login button
        loginButton.setOnClickListener {
            // Get user input
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check credentials
            if (username == "admin" && password == "admin") {
                // Clear fields
                usernameEditText.text.clear()
                passwordEditText.text.clear()

                // Navigate to ProductListFragment
                // Make sure you have the navigation action set up correctly in your nav_graph.xml
                findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
            } else {
                // Display toast message for incorrect credentials
                Toast.makeText(activity, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
