package com.example.placesco.model

import com.google.gson.annotations.SerializedName

data class Sites(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("urlPhoto")
    val urlPhoto: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("temperature")
    val temperature: String,
)