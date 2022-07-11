package com.example.recyclerviewpagination.ui.mian

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpagination.Application
import com.example.recyclerviewpagination.R
import com.example.recyclerviewpagination.data.model.PhotoModel
import com.example.recyclerviewpagination.data.viewmodel.MainViewModel
import com.example.recyclerviewpagination.data.viewmodel.ViewModelFactory
import com.example.recyclerviewpagination.utils.Status
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

	private val mainViewModel by viewModels<MainViewModel> {
		ViewModelFactory((application as Application).repository)
	}
	private lateinit var mAdapter: PhotoAdapter
	private lateinit var arrayList: ArrayList<PhotoModel>
	private lateinit var manager: LinearLayoutManager
	private var page = 1
	private var limit = 10

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		mAdapter = PhotoAdapter()
		arrayList = ArrayList()
		id_progress.visibility = View.GONE
		manager = LinearLayoutManager(this)

		getPhotos(page.toString(), limit.toString())
		loadMore()
	}

	private fun loadMore() {
		scroll_View.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
			override fun onScrollChange(
				v: NestedScrollView,
				scrollX: Int,
				scrollY: Int,
				oldScrollX: Int,
				oldScrollY: Int
			) {
				if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
					page++
					id_progress.visibility = View.VISIBLE
					getPhotos(page.toString(), limit.toString())
				}
			}

		})
//		rec_id.setOnScrollListener(object : RecyclerView.OnScrollListener() {
//			override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//				super.onScrolled(recyclerView, dx, dy)
//				if (dy == recyclerView.getChildAt(0).measuredHeight - recyclerView.measuredHeight) {
//					page++
//					id_progress.visibility = View.VISIBLE
//					getPhotos(page.toString(), limit.toString())
//				}
//			}
//		})
	}

	private fun getPhotos(page: String?, limit: String) {
		mainViewModel.getPhotos(page, limit).asLiveData().observe(this) {
			Log.d(TAG, "getPhotos: get photos response ${it.status}")

			when (it.status) {
				Status.LOADING -> {
					Log.d(TAG, "getPhotos: loading...")
				}
				Status.SUCCESS -> {
					val data = it.data
					Log.d(TAG, "getPhotos: $data")
					mAdapter.submitList(data)
					mAdapter.notifyDataSetChanged()
					id_progress.visibility = View.GONE
					rec_id.apply {
						setHasFixedSize(true)
						layoutManager = manager
						adapter = mAdapter
					}
				}
				Status.ERROR -> {
					Log.d(TAG, "getPhotos: ${it.message}")
				}
				null -> {
					Log.d(TAG, "getPhotos: ${it.message}")
				}
			}
		}
	}


}