package com.example.chimbotefood2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chimbotefood2.databinding.ActivityRestaurantBinding

import com.example.chimbotefood2.entities.Restaurant


class RestaurantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bottom navigation
        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.restaurantActivity)

        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.mainActivity -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)
                }
                R.id.restaurantActivity -> {
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

        // listView
        val listRestaurants = listOf(
            Restaurant("Cevicheria Pez Gordo", "Bruces", "123456789", "2pm a 5pm", "Les ofrecemos variedad en pescados y mariscos. Nuevo Chimbote", R.drawable.r_pezgordo ),
            Restaurant("Ceviche tres mariscos","Bruces", "123456789", "2pm a 5pm", "Pescados y mariscos", R.drawable.r_picantito ),
            Restaurant("Restaurante y menu Doña Gloria", "Bruces", "123456789", "2pm a 5pm", "Restaurante cevicheria", R.drawable.r_pezgordo ),
            Restaurant("Cevichi", "Bruces", "123456789", "10am a 2pm","Pescados y mariscos", R.drawable.r_picantito ),
            Restaurant("Gonzalito","Bruces", "123456789", "12am a 3pm", "Restaurante cevicheria", R.drawable.r_pezgordo ),
            Restaurant("Cevichi", "Bruces", "123456789", "6pm a 11pm","Pescados y mariscos", R.drawable.r_picantito ),
            Restaurant("Gonzalito","Bruces", "123456789", "10am a 5pm", "Restaurante cevicheria", R.drawable.r_pezgordo ),
            Restaurant("Cevichi", "Bruces", "123456789", "10am a 2pm","Pescados y mariscos", R.drawable.r_picantito ),
            Restaurant("Gonzalito","Bruces", "123456789", "12am a 3pm", "Restaurante cevicheria", R.drawable.r_pezgordo ),
            Restaurant("Cevichi", "Bruces", "123456789", "10am a 5pm","Pescados y mariscos", R.drawable.r_picantito ),
            Restaurant("Gonzalito","Bruces", "123456789", "10am a 3pm", "Restaurante cevicheria", R.drawable.r_pezgordo ),
            Restaurant("Cevichi", "Bruces", "123456789", "12am a 3pm","Pescados y mariscos", R.drawable.r_picantito ),
            Restaurant("Gonzalito","Bruces", "123456789", "12am a 2pm", "Restaurante cevicheria", R.drawable.r_pezgordo ),
            Restaurant("Cevichi", "Bruces", "123456789", "10am a 5pm","Pescados y mariscos", R.drawable.r_picantito ),
        )

        val adapter = RestaurantAdapter(this, listRestaurants)

        binding.listviewRestaurants.adapter = adapter

        binding.listviewRestaurants.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(this, RestaurantDetailActivity::class.java)
            intent.putExtra("restaurant", listRestaurants[position])
            startActivity(intent)
        }

    // end listView


    }
}