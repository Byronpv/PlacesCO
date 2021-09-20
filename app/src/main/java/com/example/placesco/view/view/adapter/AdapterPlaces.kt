package com.example.placesco.view.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.model.Sites
import com.squareup.picasso.Picasso

class AdapterPlaces(private val mSites: ArrayList<Sites>) : RecyclerView.Adapter<AdapterPlaces.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sites_description, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (urlPhoto, name, description, rating) = mSites[position]
        holder.nameLabel.text = name
        holder.descriptionLabel.text = description
        holder.ratingLabel.text = rating
    }

    override fun getItemCount(): Int {
        return mSites.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageLabel: ImageView = itemView.findViewById(R.id.image_poi)
        var nameLabel: TextView = itemView.findViewById(R.id.place_name)
        var descriptionLabel: TextView = itemView.findViewById(R.id.place_description)
        var ratingLabel: TextView = itemView.findViewById(R.id.rating)
    }
}