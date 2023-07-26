package com.example.myjobinterview.model

import com.squareup.moshi.Json

data class DogsResponse(
    @Json(name = "status") val status: String,
    @Json(name = "message") val images: List<String>
)