package com.example.recyclerviewpagination.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.recyclerviewpagination.data.paging.DataPagingSource
import com.example.recyclerviewpagination.data.remote.ApiBuilder

class Repository(private val apiBuilder: ApiBuilder) {

	fun getData() = Pager(
		config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false)
	) {
		DataPagingSource(apiBuilder)
	}.liveData


}