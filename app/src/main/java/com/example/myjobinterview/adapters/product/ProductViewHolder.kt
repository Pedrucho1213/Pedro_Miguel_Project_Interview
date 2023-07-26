package com.example.myjobinterview.adapters.product

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myjobinterview.databinding.CardItemProductBinding
import com.example.myjobinterview.model.Products
import com.example.myjobinterview.model.ProductsResponse
import com.example.myjobinterview.view.DetailProductActivity

class ProductViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = CardItemProductBinding.bind(view)

    fun bind(item:Products, context: Context, position: Int){
        binding.name.text = item.title
        binding.description.text = item.description
        binding.price.text = "Precio: " + item.price.toString()
        itemView.setOnClickListener {
            val intent = Intent(context, DetailProductActivity::class.java)
            intent.putExtra("product", item)
            context.startActivity(intent)
        }
    }
}

