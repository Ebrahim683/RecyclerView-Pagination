package com.example.recyclerviewpagination.data.remote

import com.example.recyclerviewpagination.data.model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

	@GET("/v2/list")
	suspend fun getPhotos(
		@Query("page") page: String?,
		@Query("limit") limit: String?
	): Response<List<PhotoModel>>

}