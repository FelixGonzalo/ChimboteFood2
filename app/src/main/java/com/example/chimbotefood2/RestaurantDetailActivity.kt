package com.example.chimbotefood2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chimbotefood2.entities.Restaurant
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        val restaurant = intent.getSerializableExtra("restaurant") as Restaurant
        tvRestaurantDetailName.text = restaurant.name
        tvRestaurantDetailLocation.text = restaurant.location
        tvRestaurantDetailPhone.text = restaurant.phone
        tvRestaurantDetailSchedule.text = restaurant.schedule
        tvRestaurantDetailDescription.text = restaurant.description
        ivRestaurantDetailimage.setImageResource(restaurant.image)
    }
}