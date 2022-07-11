package com.example.recyclerviewpagination.utils

class Resource<out T>(val data: T?, val message: String?, val status: Status?) {
	companion object {
		fun <T> loading(data: T?) =
			Resource<T>(data = data, message = null, status = Status.LOADING)

		fun <T> success(data: T?) =
			Resource<T>(data = data, message = null, status = Status.SUCCESS)

		fun <T> error(message: String?) =
			Resource<T>(data = null, message = message, status = Status.ERROR)
	}
}