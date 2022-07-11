package com.example.recyclerviewpagination.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewpagination.data.repository.Repository

class ViewModelFactory(private val repository: Repository) :
	ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return (MainViewModel(repository)) as T
	}
}