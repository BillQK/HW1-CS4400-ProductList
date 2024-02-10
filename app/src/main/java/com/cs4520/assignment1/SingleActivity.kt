package com.cs4520.assignment1

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings.LayoutAlgorithm
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.cs4520.assignment1.databinding.ActivityMainBinding
import kotlin.math.log


class SingleActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val view = binding.root
        setContentView(view)

    }


}