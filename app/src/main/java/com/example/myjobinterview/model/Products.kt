package com.example.myjobinterview.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Products(
    @SerializedName("id"                 ) var id                 : Int?              = null,
    @SerializedName("title"              ) var title              : String?           = null,
    @SerializedName("description"        ) var description        : String?           = null,
    @SerializedName("price"              ) var price              : Int?              = null,
    @SerializedName("discountPercentage" ) var discountPercentage : Double?           = null,
    @SerializedName("rating"             ) var rating             : Double?           = null,
    @SerializedName("stock"              ) var stock              : Int?              = null,
    @SerializedName("brand"              ) var brand              : String?           = null,
    @SerializedName("category"           ) var category           : String?           = null,
    @SerializedName("thumbnail"          ) var thumbnail          : String?           = null,
    @SerializedName("images"             ) var images             : ArrayList<String> = arrayListOf()

) : Parcelable 