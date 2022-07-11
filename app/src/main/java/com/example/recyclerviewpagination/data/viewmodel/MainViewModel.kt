package com.example.recyclerviewpagination.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recyclerviewpagination.data.repository.Repository
import com.example.recyclerviewpagination.utils.Resource
import kotlinx.coroutines.flow.flow

class MainViewModel(private val repository: Repository) : ViewModel() {
	fun getPhotos(page: String?, limit: String) = flow {
		emit(Resource.loading(null))

		try {
			val response = repository.getPhotos(page, limit)
			when (response.code()) {
				200 -> {
					emit(Resource.success(response.body()))
				}
				else -> {
					emit(Resource.error(response.code().toString()))
				}
			}
		} catch (e: Exception) {
			emit(Resource.error(e.localizedMessage))
		}
	}
}