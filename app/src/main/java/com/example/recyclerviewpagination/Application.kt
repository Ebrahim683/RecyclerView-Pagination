package com.example.recyclerviewpagination

import android.app.Application
import com.example.recyclerviewpagination.data.remote.ApiBuilder
import com.example.recyclerviewpagination.data.repository.Repository

class Application() : Application() {
	val apiBuilder by lazy {
		ApiBuilder()
	}
	val repository by lazy {
		Repository(apiBuilder = apiBuilder)
	}
}