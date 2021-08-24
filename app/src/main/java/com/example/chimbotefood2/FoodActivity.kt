package com.example.chimbotefood2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chimbotefood2.databinding.ActivityFoodBinding
import com.example.chimbotefood2.entities.Food


class FoodActivity : AppCompatActivity() {

    private lateinit var adapter:FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // bottom navigation
        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.foodActivity)

        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.mainActivity -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,0)
                }
                R.id.restaurantActivity -> {
                    val intent2 = Intent(this, RestaurantActivity::class.java)
                    startActivity(intent2)
                    overridePendingTransition(0,0)
                }
                R.id.foodActivity -> {
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

        // recyclerview
        adapter = FoodAdapter(this)
        binding.recyclerviewFood.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewFood.adapter = adapter

        val foodList : MutableList<Food> = mutableListOf<Food>()
        foodList.add(Food("Ceviche Chimbotano", "Ceviche Chimbotano con mariscos", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg"))
        foodList.add(Food("Chicharron de Pescado", "Chicharron de pescado", "https://jameaperu.com/wp-content/uploads/2019/09/chicharron-de-pescado_700x467.jpg"))
        foodList.add(Food("Jugoso de Pescado", "Fuente de Jugoso Chimbotano", "https://cdn.statically.io/img/www.comeperuano.pe/wp-content/uploads/2020/04/sudado-de-pescado.jpg?quality=100&f=auto"))
        foodList.add(Food("Ceviche Chimbotano", "Ceviche Chimbotano con mariscos", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg"))
        foodList.add(Food("Chicharron de Pescado", "Chicharron de pescado", "https://jameaperu.com/wp-content/uploads/2019/09/chicharron-de-pescado_700x467.jpg"))
        foodList.add(Food("Jugoso de Pescado", "Fuente de Jugoso Chimbotano", "https://cdn.statically.io/img/www.comeperuano.pe/wp-content/uploads/2020/04/sudado-de-pescado.jpg?quality=100&f=auto"))
        foodList.add(Food("Ceviche Chimbotano", "Ceviche Chimbotano con mariscos", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg"))
        foodList.add(Food("Chicharron de Pescado", "Chicharron de pescado", "https://jameaperu.com/wp-content/uploads/2019/09/chicharron-de-pescado_700x467.jpg"))
        foodList.add(Food("Jugoso de Pescado", "Fuente de Jugoso Chimbotano", "https://cdn.statically.io/img/www.comeperuano.pe/wp-content/uploads/2020/04/sudado-de-pescado.jpg?quality=100&f=auto"))
        foodList.add(Food("Ceviche Chimbotano", "Ceviche Chimbotano con mariscos", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg"))
        foodList.add(Food("Chicharron de Pescado", "Chicharron de pescado", "https://jameaperu.com/wp-content/uploads/2019/09/chicharron-de-pescado_700x467.jpg"))
        foodList.add(Food("Jugoso de Pescado", "Fuente de Jugoso Chimbotano", "https://cdn.statically.io/img/www.comeperuano.pe/wp-content/uploads/2020/04/sudado-de-pescado.jpg?quality=100&f=auto"))
        foodList.add(Food("Ceviche Chimbotano", "Ceviche Chimbotano con mariscos", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg"))
        foodList.add(Food("Chicharron de Pescado", "Chicharron de pescado", "https://jameaperu.com/wp-content/uploads/2019/09/chicharron-de-pescado_700x467.jpg"))
        foodList.add(Food("Jugoso de Pescado", "Fuente de Jugoso Chimbotano", "https://cdn.statically.io/img/www.comeperuano.pe/wp-content/uploads/2020/04/sudado-de-pescado.jpg?quality=100&f=auto"))
        foodList.add(Food("Ceviche Chimbotano", "Ceviche Chimbotano con mariscos", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-carretillero_700x467-697x465.jpg"))
        foodList.add(Food("Chicharron de Pescado", "Chicharron de pescado", "https://jameaperu.com/wp-content/uploads/2019/09/chicharron-de-pescado_700x467.jpg"))
        foodList.add(Food("Jugoso de Pescado", "Fuente de Jugoso Chimbotano", "https://cdn.statically.io/img/www.comeperuano.pe/wp-content/uploads/2020/04/sudado-de-pescado.jpg?quality=100&f=auto"))


        adapter.setListData(foodList)
        adapter.notifyDataSetChanged()

        // end recyclerview

    }
}