package com.example.lojavirtual.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojavirtual.adapter.RecyclerAdapter
import com.example.lojavirtual.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var recipesList: ArrayList<Recipes>
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        recyclerAdapter= RecyclerAdapter(recipesList)
        recyclerView.adapter = recyclerAdapter
        setList()
    }

    private fun setList(){
        val recipe1 = Recipes("","Pizza Calabresa","R$ 4,50")
        recipesList.add(recipe1)
        val recipe2 = Recipes("","Pizza Mussarela","R$ 4,00")
        recipesList.add(recipe2)
        val recipe3 = Recipes("","Pizza Beijinho + Óreo","R$ 3,20")
        recipesList.add(recipe3)
        val recipe4 = Recipes("","Pastelão","R$ 4,00")
        recipesList.add(recipe4)
        val recipe5 = Recipes("","Palha Italiana","R$ 3,00")
        recipesList.add(recipe5)
        val recipe6 = Recipes("","Brigadeiro","R$ 1,50")
        recipesList.add(recipe6)
        val recipe7 = Recipes("","Surpresa de uva","R$ 1,75")
        recipesList.add(recipe7)
        val recipe8 = Recipes("","Pizza Chocolate","R$ 1,50")
        recipesList.add(recipe8)
    }
}