package com.example.chimbotefood2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chimbotefood2.databinding.ActivityMainBinding
import com.example.chimbotefood2.helloar.HelloArActivity
import com.example.chimbotefood2.ui.FoodActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bottom navigation
        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.mainActivity)

        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.mainActivity -> {
                }
                R.id.restaurantActivity -> {
                    val intent2 = Intent(this, RestaurantActivity::class.java)
                    startActivity(intent2)
                    overridePendingTransition(0,0)
                }
                R.id.foodActivity -> {
                    val intent2 = Intent(this, FoodActivity::class.java)
                    startActivity(intent2)
                    overridePendingTransition(0,0)
                }
                R.id.aboutActivity -> {
                    val intent3 = Intent(this, AboutActivity::class.java)
                    startActivity(intent3)
                    overridePendingTransition(0,0)
                }
            }
            true
        }
        // end bottom navigation

        // Arcore

        binding.buttonArcore.setOnClickListener{
            val newintent = Intent(this, HelloArActivity::class.java)
            startActivity(newintent)
            overridePendingTransition(0,0)
        }

        // end Arcore
    }
}