package com.example.lojavirtual.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lojavirtual.adapter.RecyclerAdapter
import com.example.lojavirtual.databinding.ActivityHomeBinding
import com.example.lojavirtual.model.Recipes

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
        val recipe1 = Recipes("https://sgnh.com.br/wp-content/uploads/2021/07/pizza_calabresa.png","Pizza Calabresa","R$ 4,50")
        recipesList.add(recipe1)
        val recipe2 = Recipes("https://superpao.vtexassets.com/arquivos/ids/429222/Pizza-de-Mucarela-Superpao-kg.jpg?v=638481793492170000","Pizza Mussarela","R$ 4,00")
        recipesList.add(recipe2)
        val recipe3 = Recipes("https://bigbangpizzaria.com.br/detalhes/476601ebf65f6b9937a9cedb56321023.jpg","Pizza Beijinho + Óreo","R$ 3,20")
        recipesList.add(recipe3)
        val recipe4 = Recipes("https://www.hojetemfrango.com.br/wp-content/uploads/2018/11/Torta-integral-de-frango.jpg","Pastelão Frango","R$ 4,00")
        recipesList.add(recipe4)
        val recipe5 = Recipes("https://www.conqualita.com.br/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/p/a/palha-italiana-3.jpg","Palha Italiana","R$ 3,00")
        recipesList.add(recipe5)
        val recipe6 = Recipes("https://img.freepik.com/fotos-premium/brigadeiro-brasileiro-tradicional-isolado-na-superficie-branca_70216-368.jpg","Brigadeiro","R$ 1,50")
        recipesList.add(recipe6)
        val recipe7 = Recipes("https://images.tcdn.com.br/img/img_prod/935474/brigadeiro_surpresa_de_uva_239_1_d89c117678af0bbf9aa9fd26fc822af6.jpg","Surpresa de uva","R$ 1,75")
        recipesList.add(recipe7)
        val recipe8 = Recipes("https://biancapizzaria.com.br/wp-content/uploads/2015/06/44-chocolatePretomms22-233x200@2x.png","Pizza Chocolate","R$ 1,50")
        recipesList.add(recipe8)
    }
}