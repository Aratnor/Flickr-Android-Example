package com.lambadam.flickrexample.listPhotos

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lambadam.domain.model.photoModels.Photo
import com.lambadam.flickrexample.R


class ListPhotosAdapter(private val context: Context,
                        customPhotos: List<Photo>,
                        onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<ListPhotosAdapter.ViewHolder>() {

    private var photos: MutableList<Photo> = customPhotos.toMutableList()

    private val mOnItemClickListener: OnItemClickListener = onItemClickListener

    interface OnItemClickListener {
        fun onItemClick(photo: Photo,photoUrl: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.photo_recycler_item,parent,false)
        val viewHolder = ViewHolder(itemView)
        viewHolder.itemView.setOnClickListener{
            mOnItemClickListener.onItemClick(photos[viewHolder.adapterPosition],
                preparePhotoUrl(photos[viewHolder.adapterPosition]))
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageView =holder.itemView.findViewById<ImageView>(R.id.photo_image_view)
        val photo = photos[position]
        val url = preparePhotoUrl(photo)
        Glide
            .with(context)
            .load(url)
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
    fun updatePhotos(newPhotos: List<Photo> ) {
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    private fun preparePhotoUrl(photo: Photo): String {
        return "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}