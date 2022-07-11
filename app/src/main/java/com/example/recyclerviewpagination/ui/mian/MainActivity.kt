package com.example.recyclerviewpagination.ui.mian

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpagination.Application
import com.example.recyclerviewpagination.R
import com.example.recyclerviewpagination.data.paging.DataAdapter
import com.example.recyclerviewpagination.data.viewmodel.MainViewModel
import com.example.recyclerviewpagination.data.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking

private const val TAG = "mainActivity"

class MainActivity : AppCompatActivity() {

	private val mainViewModel by viewModels<MainViewModel> {
		ViewModelFactory(
			(application as Application).repository
		)
	}
	private lateinit var mAdapter: DataAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		mAdapter = DataAdapter()

		setView()
		runBlocking {
			mainViewModel.data.observe(this@MainActivity, Observer {
				Log.d(TAG, "onCreate: $it")
				mAdapter.submitData(lifecycle, it)
			})
		}
	}

	private fun setView() {
		rec_id.apply {
			setHasFixedSize(true)
			layoutManager = LinearLayoutManager(this@MainActivity)
			adapter = mAdapter
		}
	}

}