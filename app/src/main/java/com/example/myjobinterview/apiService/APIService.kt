package com.example.myjobinterview.apiService

import com.example.myjobinterview.model.DogsResponse
import com.example.myjobinterview.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponse>

    @GET("/products")
    suspend fun getProducts(): Response<ProductsResponse>
}