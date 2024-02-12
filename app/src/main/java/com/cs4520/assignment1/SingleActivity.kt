package com.cs4520.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cs4520.assignment1.databinding.ActivityMainBinding


class SingleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /*
    The onCreate method is a lifecycle callback that runs when the
    activity is being created. It is where you perform initial setup.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}