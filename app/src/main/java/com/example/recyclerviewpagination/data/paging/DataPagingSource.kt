package com.example.recyclerviewpagination.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.recyclerviewpagination.data.model.ModelDataItem
import com.example.recyclerviewpagination.data.remote.ApiBuilder

class DataPagingSource(private val apiBuilder: ApiBuilder) : PagingSource<Int, ModelDataItem>() {

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ModelDataItem> {
		val page = params.key ?: 1
		return try {
			val response = apiBuilder.getApiService().getData(page, params.loadSize)
			LoadResult.Page(
				data = response,
				prevKey = if (page == 1) null else page - 1,
				nextKey = if (response.isEmpty()) null else page + 1
			)
		} catch (e: Exception) {
			LoadResult.Error(e)
		}
	}

	override fun getRefreshKey(state: PagingState<Int, ModelDataItem>): Int? {
		return state.anchorPosition?.let {
			state.closestPageToPosition(it)?.prevKey?.plus(1)
				?: state.closestPageToPosition(it)?.nextKey?.minus(1)
		}
	}
}