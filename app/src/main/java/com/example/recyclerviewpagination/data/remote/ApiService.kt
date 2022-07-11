package com.example.recyclerviewpagination.data.remote

import com.example.recyclerviewpagination.data.model.ModelDataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

	@GET("/v1/images/search")
	suspend fun getData(
		@Query("page") page: Int?,
		@Query("limit") limit: Int?
	): List<ModelDataItem>

}