package com.example.chimbotefood2.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chimbotefood2.entities.Food
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    fun getPlatosData():LiveData<MutableList<Food>>{
        val mutableData = MutableLiveData<MutableList<Food>>()
        // obtener datos de firebase
        FirebaseFirestore.getInstance().collection("platos").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Food>()
            for (document in result){
                val image = document.getString("image")
                val name = document.getString("name")
                val summary = document.getString("summary")
                val food = Food(name!!, summary!!, image!!)
                listData.add(food)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}