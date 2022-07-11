package com.example.recyclerviewpagination.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiBuilder {

	var baseUrl = "https://picsum.photos"

	fun getRetrofit(): Retrofit {
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.addConverterFactory(ScalarsConverterFactory.create())
			.build()
	}

	fun getApiService(): ApiService = ApiBuilder().getRetrofit().create(ApiService::class.java)
}