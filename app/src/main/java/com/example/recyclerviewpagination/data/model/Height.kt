package com.example.recyclerviewpagination.data.model


import com.google.gson.annotations.SerializedName

data class Height(
    @SerializedName("imperial")
    val imperial: String?, // 10
    @SerializedName("metric")
    val metric: String? // 25
)