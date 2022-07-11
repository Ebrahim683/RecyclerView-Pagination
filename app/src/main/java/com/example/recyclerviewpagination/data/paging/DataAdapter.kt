package com.example.recyclerviewpagination.data.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpagination.R
import com.example.recyclerviewpagination.data.model.ModelDataItem
import com.squareup.picasso.Picasso

class DataAdapter : PagingDataAdapter<ModelDataItem, DataAdapter.DataViewHolder>(diffUtil) {

	companion object {
		val diffUtil = object : DiffUtil.ItemCallback<ModelDataItem>() {
			override fun areItemsTheSame(oldItem: ModelDataItem, newItem: ModelDataItem): Boolean {
				return oldItem.url == newItem.url &&
						oldItem.id == newItem.id
			}

			override fun areContentsTheSame(
				oldItem: ModelDataItem,
				newItem: ModelDataItem
			): Boolean {
				return oldItem.url == newItem.url &&
						oldItem.id == newItem.id
			}

		}
	}

	class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val sample_image: ImageView = view.findViewById(R.id.sample_image)
		val sample_title: TextView = view.findViewById(R.id.sample_title)

		fun bind(modelDataItem: ModelDataItem) {
			Picasso.get().load(modelDataItem.url).into(sample_image)
			sample_title.text = modelDataItem.id
		}
	}

	override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
		val modelDataItem = getItem(position)
		if (modelDataItem != null) {
			holder.bind(modelDataItem)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.rec_row, parent, false)
		return DataViewHolder(view)
	}
}