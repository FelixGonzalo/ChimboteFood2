package com.example.chimbotefood2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chimbotefood2.databinding.ActivityRestaurantBinding

import com.example.chimbotefood2.entities.Restaurant
import com.example.chimbotefood2.ui.FoodActivity


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
            Restaurant("Mar & Luna","Jr. Villavicencio 104 Esquina con Malecon Grau", "+5143325320", "10:00am a 11:00pm", "Ofrecemos todo tipo de comida Peruana, Sudamericana y Mariscos", R.drawable.r_solyluna),
            Restaurant("La Sazón de Paola","Av. Pacifico 464 Nuevo Chimbote 02711", "+5143622600", "8:00am a 8:00pm", "Ofrecemos todo tipo de platos Peruanos, Parrillas y más", R.drawable.r_sazondepaola),
            Restaurant("Rico Chimbote","Jiron Enrique Palacios 703 Chimbote 02803", "936664141", "8:00am a 10:00pm", "Ofrecemos todo tipo de comidas tipicas criollas, Pescados y Mariscos", R.drawable.r_ricochimbote),
            Restaurant("Portón Gaucho","Jirón Huascarán 10 Nuevo Chimbote", "(043)315534", "12:00pm a 11:30pm", "Ofrecemos todo tipo de comidas tipicas criollas y Parrilladas", R.drawable.s_portongaucho),
            Restaurant("Cevicheria el Gold Marino","Urb. Antúnez de Mayolo Mz. F Lte 5 Chimbote", "943671903", "10:00am a 4:00pm", "Ofrecemos todo tipo de variedad en Pescados y Mariscos", R.drawable.r_golmarino),
            Restaurant("Restaurant Venecia","Francisco Bolognesi 386 Chimbote 02800 Perú", "+5143325490", "8:00am a 8:00pm", "Ofrecemos variados platos a la carta y Parrillas", R.drawable.r_venecia),
            Restaurant("La Cochera Campestre","La Campina S/N km 31/2 Chimbote", "+5143323764", "9:00am a 6:00pm", "Ofrecemos variados platos a la carta y Parrillas", R.drawable.r_cocheracampestre),
            Restaurant("Recreo Campestre Rosita","Av Buenos Aires Chimbote 02802", "+5143769662", "7:00am a 10:00pm", "Ofrecemos deliciosos platos criollos de alta calidad", R.drawable.r_campestrerosita),
            Restaurant("Cevicheria Mil Sabores","Av Camino Real Mz. Z Lt 8 PJ. La victoria Chimbote", "973018091", "7:00am a 10:00pm", "Ofrecemos todo tipo de variedad en Pescados y Mariscos", R.drawable.r_milsabores),
            Restaurant("El Cevichon","Av Leoncio Prado 160 Chimbote", "981143466", "7:00am a 8:00pm", "Ofrecemos todo tipo de comida como platos Peruanos, Mariscos, Española y Sudamericana", R.drawable.r_cevichon),
            Restaurant("Cevicheria Pez Gordo", "dirección de ejemplo", "123456789", "2pm a 5pm", "Les ofrecemos variedad en pescados y mariscos. Nuevo Chimbote", R.drawable.r_pezgordo ),
            Restaurant("Ceviche tres mariscos","Bruces", "123456789", "2pm a 5pm", "Pescados y mariscos", R.drawable.r_picantito ),
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