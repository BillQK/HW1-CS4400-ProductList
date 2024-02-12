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


/*
This class extends Fragment, making it a component that can be added to an activity to encapsulate
 its own UI and behavior.
 */
class LoginFragment : Fragment() {
     /*
     onCreateView is called to inflate the fragment's layout. LayoutInflater converts an XML layout file
     into corresponding ViewGroups and Widgets. ViewGroup container is the parent view that the
     fragment's UI should be attached to. savedInstanceState contains data supplied when the fragment
     was recreated.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         // Inflate the layout for this fragment from fragment_login.xml.
        val view = inflater.inflate(R.layout.fragment_login, container, false)

         // Initialize views by finding them by their ID. This process is fundamental for interacting
         // with UI elements in Android.
        val usernameEditText = view.findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val loginButton = view.findViewById<Button>(R.id.loginButton)

         // Set a click listener on the login button to handle user interaction.
        loginButton.setOnClickListener {
            // Retrieve user input from EditText fields
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check credentials
            if (username == "admin" && password == "admin") {
                // Clear fields
                usernameEditText.text.clear()
                passwordEditText.text.clear()

                // Navigate to ProductListFragment
                findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
            } else {
                // Display toast message for incorrect credentials
                Toast.makeText(activity, "Incorrect username or password", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        return view
    }
}
