package com.example.chimbotefood2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chimbotefood2.domain.data.network.Repo
import com.example.chimbotefood2.entities.Food

class FoodViewModel: ViewModel() {
    private val repo = Repo()
    fun fetchFoodData() : LiveData<MutableList<Food>> {
        val mutableData = MutableLiveData<MutableList<Food>>()
        repo.getPlatosData().observeForever{ platosList ->
            mutableData.value = platosList
        }
        return mutableData
    }
}