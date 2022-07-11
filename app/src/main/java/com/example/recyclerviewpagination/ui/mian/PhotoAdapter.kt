package com.example.recyclerviewpagination.ui.mian

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpagination.R
import com.example.recyclerviewpagination.data.model.PhotoModel
import com.squareup.picasso.Picasso

class PhotoAdapter : ListAdapter<PhotoModel, PhotoAdapter.PhotoViewHolder>(diffUtil) {

	class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val sample_image: ImageView = view.findViewById(R.id.sample_image)
		val sample_title: TextView = view.findViewById(R.id.sample_title)
		fun bind(photoModel: PhotoModel) {
			Picasso.get().load(photoModel.thumbnailUrl).into(sample_image)
			sample_title.text = photoModel.title
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.rec_row, parent, false)
		return PhotoViewHolder(view)
	}

	override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
		val photoModel = getItem(position)
		holder.bind(photoModel)
	}

	companion object {
		val diffUtil = object : DiffUtil.ItemCallback<PhotoModel>() {
			override fun areItemsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean {
				return oldItem.id == newItem.id &&
						oldItem.url == newItem.url &&
						oldItem.albumId == newItem.albumId &&
						oldItem.title == newItem.title &&
						oldItem.thumbnailUrl == newItem.thumbnailUrl
			}

			override fun areContentsTheSame(oldItem: PhotoModel, newItem: PhotoModel): Boolean {
				return oldItem.id == newItem.id &&
						oldItem.url == newItem.url &&
						oldItem.albumId == newItem.albumId &&
						oldItem.title == newItem.title &&
						oldItem.thumbnailUrl == newItem.thumbnailUrl
			}

		}
	}

}