package com.example.recyclerviewpagination.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recyclerviewpagination.data.repository.Repository

class MainViewModel(private val repository: Repository) :
	ViewModel() {

	val data = repository.getData()

}