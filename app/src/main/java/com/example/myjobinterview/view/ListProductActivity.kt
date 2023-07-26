package com.example.myjobinterview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myjobinterview.R
import com.example.myjobinterview.adapters.product.ProductAdapter
import com.example.myjobinterview.apiService.APIService
import com.example.myjobinterview.databinding.ActivityListProductBinding
import com.example.myjobinterview.model.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ListProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListProductBinding
    private var products = mutableListOf<Products>()
    private lateinit var adapter:ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getProduct(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initReciclerView(){
        adapter = ProductAdapter(products, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = getProduct().create(APIService::class.java).getProducts()
                val data = call.body()
                runOnUiThread {
                    if (call.isSuccessful) {
                        val items = data?.products ?: emptyList()
                        products.clear()
                        products.addAll(items)
                        initReciclerView()
                    } else {
                        showError()
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Log.d("error", e.toString())
                    print(e)}
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

}