package com.example.lojavirtual.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.lojavirtual.R
import com.example.lojavirtual.model.Recipes
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val recipes: MutableList<Recipes>): RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipes_item, parent, false)
        return RecyclerAdapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapterViewHolder, position: Int) {

        Picasso.get().load(recipes[position].link).into(holder.recipeImg)
        holder.recipeName.text = recipes[position].name
        holder.recipePrice.text = recipes[position].price
    }

    inner class RecyclerAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val recipeImg = itemView.findViewById<ImageView>(R.id.recipe_img)
        val recipeName = itemView.findViewById<TextView>(R.id.recipe_name)
        val recipePrice = itemView.findViewById<TextView>(R.id.recipe_price)
    }
}
