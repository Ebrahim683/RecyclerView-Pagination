package com.example.recyclerviewpagination.data.model


import com.google.gson.annotations.SerializedName

data class PhotoModel(
	@SerializedName("albumId")
	val albumId: Int?, // 1
	@SerializedName("id")
	val id: Int?, // 1
	@SerializedName("author")
	val title: String?, // accusamus beatae ad facilis cum similique qui sunt
	@SerializedName("url")
	val url: String?, // https://via.placeholder.com/600/92c952
	@SerializedName("download_url")
	val thumbnailUrl: String? // https://via.placeholder.com/150/92c952
)