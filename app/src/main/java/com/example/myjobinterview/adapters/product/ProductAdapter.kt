package com.example.myjobinterview.adapters.product

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myjobinterview.R
import com.example.myjobinterview.model.Products

class ProductAdapter(private val products: List<Products>, private val context: Context) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutinflater.inflate(R.layout.card_item_product, parent, false))
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = products[position]
        holder.bind(item, context, position)
    }

}