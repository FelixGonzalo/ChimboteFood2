package com.example.chimbotefood2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chimbotefood2.entities.Food
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(private val context: Context): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var dataList = mutableListOf<Food>()

    fun setListData(data:MutableList<Food>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food:Food = dataList[position]
        holder.bindView(food)
    }

    override fun getItemCount(): Int {
        if(dataList.size > 0) {
            return dataList.size
        } else {
            return 0
        }
    }

    inner class FoodViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun bindView(food:Food){
            Glide.with(context).load(food.image).into(itemView.civFoodImage)
            itemView.tvFoodName.text = food.name
            itemView.tvFoodSummary.text = food.summary
        }
    }
}