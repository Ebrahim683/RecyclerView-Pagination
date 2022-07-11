package com.example.recyclerviewpagination.data.model


import com.google.gson.annotations.SerializedName

data class ModelDataItem(
    @SerializedName("breeds")
    val breeds: List<Breed?>?,
    @SerializedName("id")
    val id: String?, // SkIgzxqNQ
    @SerializedName("url")
    val url: String?, // https://cdn2.thedogapi.com/images/SkIgzxqNQ_1280.jpg
    @SerializedName("width")
    val width: Int?, // 800
    @SerializedName("height")
    val height: Int? // 696
)