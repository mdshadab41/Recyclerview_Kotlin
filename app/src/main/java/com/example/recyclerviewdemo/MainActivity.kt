package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FoodItemAdapter
    private val foodItemsList: MutableList<FoodItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        populateList()
        setUpAdapter()
    }

    private fun populateList() {
        for (i in 1..15) {
            val name = "Food Item $i"
            val price = (100 * i).toFloat()

            val foodItem = FoodItem(name = name, price = price)

            foodItemsList.add(foodItem)
        }
    }

    private fun setUpAdapter() {
        adapter = FoodItemAdapter(this, foodItemsList)

        binding.fooditemRV.adapter = adapter
        binding.fooditemRV.layoutManager = LinearLayoutManager(this)


    }
}
