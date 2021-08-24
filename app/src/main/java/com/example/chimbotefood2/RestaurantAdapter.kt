package com.example.chimbotefood2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.chimbotefood2.entities.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantAdapter(private val myContext: Context, private val listRestaurants: List<Restaurant>) : ArrayAdapter<Restaurant>(myContext, 0, listRestaurants) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(myContext).inflate(R.layout.item_restaurant, parent, false)
        val restaurant = listRestaurants[position]

        layout.textViewRestaurant.text = restaurant.name
        layout.textViewRestaurantSchedule.text = restaurant.schedule
        layout.imageViewRestaurant.setImageResource(restaurant.image)
        return layout
    }
}