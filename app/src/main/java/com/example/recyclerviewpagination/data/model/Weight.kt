package com.example.recyclerviewpagination.data.model


import com.google.gson.annotations.SerializedName

data class Weight(
    @SerializedName("imperial")
    val imperial: String?, // 8 - 14
    @SerializedName("metric")
    val metric: String? // 4 - 6
)