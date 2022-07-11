package com.example.recyclerviewpagination.data.model


import com.google.gson.annotations.SerializedName

data class Breed(
    @SerializedName("weight")
    val weight: Weight?,
    @SerializedName("height")
    val height: Height?,
    @SerializedName("id")
    val id: Int?, // 104
    @SerializedName("name")
    val name: String?, // English Toy Spaniel
    @SerializedName("bred_for")
    val bredFor: String?, // Companion of kings
    @SerializedName("breed_group")
    val breedGroup: String?, // Toy
    @SerializedName("life_span")
    val lifeSpan: String?, // 10 - 12 years
    @SerializedName("temperament")
    val temperament: String?, // Affectionate, Reserved, Playful, Gentle, Happy, Loving
    @SerializedName("reference_image_id")
    val referenceImageId: String?, // SkIgzxqNQ
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("country_code")
    val countryCode: String? // AU
)