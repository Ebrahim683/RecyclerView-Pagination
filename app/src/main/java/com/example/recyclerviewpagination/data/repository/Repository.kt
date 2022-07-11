package com.example.recyclerviewpagination.data.repository

import com.example.recyclerviewpagination.data.remote.ApiBuilder

class Repository(private val apiBuilder: ApiBuilder) {
	suspend fun getPhotos(page: String?, limit: String) = apiBuilder.getApiService().getPhotos(page, limit)
}