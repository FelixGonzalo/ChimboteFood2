package com.example.chimbotefood2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chimbotefood2.*
import com.example.chimbotefood2.databinding.ActivityFoodBinding
import com.example.chimbotefood2.entities.Food
import com.example.chimbotefood2.viewmodel.FoodViewModel
import kotlinx.android.synthetic.main.activity_food.*


class FoodActivity : AppCompatActivity() {

    private lateinit var adapter: FoodAdapter
    private val viewModel by lazy { ViewModelProviders.of(this).get(FoodViewModel::class.java) }

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
        foodList.add(Food("Causa de Pescado", "En Chimbote resalta la causa de pescado. Se suele elaborar con pescado salado como la Caballa y se complementa con el aderezo, ajos, cebollas y demás condimentos.", "https://e.rpp-noticias.io/medium/2018/12/11/400940_724550.png"))
        foodList.add(Food("Ceviche Chimbotano", "Este plato resulta ideal para el clima de Chimbote y es muy similar a las preparaciones del ceviche norteño, pero con la diferencia que el Ceviche Chimbotano utiliza ají colorado molido como aderezo.", "https://cde.peru.com//ima/0/1/4/9/6/1496860/380x300/youtube.jpg"))
        foodList.add(Food("Chinguirito", "Se suele ofrecer como entrada o piqueo en los restaurantes. Se elabora con pescado seco y deshilachado y se sazona con limón, ají amarillo, sal y otros condimentos.", "https://i.pinimg.com/originals/56/af/9b/56af9bdf35de562285b723b6751a3859.jpg"))
        foodList.add(Food("Frejolada de Pato", "Es uno de los platos más pedidos en los restaurantes de menús en la ciudad. Se prepara con pato tierno, frejoles, zanahoria, yuca, alverjas, arroz y se acompaña con una salsa de cebolla con su toque picante.", "https://chefalpaso.com/wp-content/uploads/2013/11/pato-guisado.jpg"))
        foodList.add(Food("Jugoso", "Es un caldo con el sabor concentrado del pescado. Entre los ingredientes que le brindan sabor al pescado están la chicha de jora, el rocoto, el ají amarillo, la cebolla y el limón.", "https://i.pinimg.com/originals/2a/42/e3/2a42e31adc98f92c7075938b9f27b3cb.jpg"))
        foodList.add(Food("Caldo de Jeta", "Se trata de una sopa que es consumida especialmente luego de una gran fiesta para reponer fuerzas. Se elabora con la jeta del ganado vacuno, papa, mote, hierbabuena, perejil y culantro", "http://www.akunta.org/casona/wp-content/uploads/2019/12/CALDO-DE-CABEZA-DE-CARNERO-CON-MOTE-LA-CXASONA.jpg"))
        foodList.add(Food("Ceviche Combinado", "Es un tipo de ceviche que resulta de la unión de hasta tres platos de la cocina peruana: El ceviche clásico, los tallarines rojos y la papa a la huancaína. Aunque también se suele adicionar otros preparados como la chanfainita.", "https://micevichedehoy.com/wp-content/uploads/2018/10/ceviche-combinado_700x466-300x180.jpg"))
        foodList.add(Food("Escabeche de Pescado", "Es un plato que combina mariscos frescos y diferentes ajíes típicos del Perú en una salsa agridulce picante y refrescante. Este plato es ideal para una tarde de verano.", "https://3.bp.blogspot.com/-AGTytkPvbAc/WQz6rdBxZbI/AAAAAAAAJZ0/3f4sc3PdTvQTYghOUiInU1gLMeQHf-ZIgCLcB/s1600/escabeche-pescado.jpg"))
        foodList.add(Food("Jalea de Pescado", "Es un buen plato a base de pescados y mariscos para disfrutar en verano. Este plato lleva consigo pescado, mariscos, harina, chuño, huevo, limón y diferente tipos de ajíes.", "https://images-gmi-pmc.edge-generalmills.com/3ece958a-cb33-40c1-8307-5479a6d3eed2.jpg"))
        foodList.add(Food("Sudado de Pescado", "Es un plato de fondo muy bueno. Para el sudado de pescado se suele usar la lorna, pero se puede sustituir por cualquier pescado de roca. Además del pescado se utiliza ingredientes como la cebolla, el tomate, los ajíes, cebolleta ramas de cilantro y limón.", "https://img-global.cpcdn.com/recipes/7789879d7e482655/751x532cq70/sudado-de-pescado-bonito-foto-principal.jpg"))

        adapter.setListData(foodList)
        adapter.notifyDataSetChanged()
        shimmer_view_container.visibility = View.GONE

        // end recyclerview

        //aplicando FIREBASE
        //observeData(binding)

    }

    fun observeData(binding : ActivityFoodBinding) {
        binding.shimmerViewContainer.startShimmer()
        viewModel.fetchFoodData().observe(this, Observer {
            shimmer_view_container.stopShimmer()
            shimmer_view_container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}