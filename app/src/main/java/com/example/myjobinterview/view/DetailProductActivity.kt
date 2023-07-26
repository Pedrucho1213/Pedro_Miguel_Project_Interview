package com.example.myjobinterview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myjobinterview.R
import com.example.myjobinterview.databinding.ActivityDetailProductBinding
import com.example.myjobinterview.model.Products
import com.squareup.picasso.Picasso

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product: Products = intent.getParcelableExtra<Products>("product")!!

        binding.details.text = product.description
        binding.priceLabel.text = "Precio: "+product.price
        binding.detailTitle.text = product.title
        Picasso.get().load(product.images[0]).into(binding.imageDetail)

        binding.closeButton.setOnClickListener {
            finish()
        }

    }
}