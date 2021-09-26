package com.example.placesco.view.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.model.Sites
import com.example.poi.ClickListener
import com.squareup.picasso.Picasso

class AdapterPlaces(private val mSites: ArrayList<Sites>, private val clickListener: ClickListener) : RecyclerView.Adapter<AdapterPlaces.ViewHolder>() {

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
        Picasso.get().load(urlPhoto).into(holder.imageLabel)
        val listener = holder.descriptionLabel
        val listener2 = holder.imageLabel
        val listener3 = holder.nameLabel
        val listener4 = holder.ratingLabel
        listener.setOnClickListener {
            clickListener.onItemClicked(position)
        }
        listener2.setOnClickListener {
            clickListener.onItemClicked(position)
        }
        listener3.setOnClickListener {
            clickListener.onItemClicked(position)
        }
        listener4.setOnClickListener {
            clickListener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return mSites.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageLabel: ImageView = itemView.findViewById(R.id.image_profile)
        var nameLabel: TextView = itemView.findViewById(R.id.place_name)
        var descriptionLabel: TextView = itemView.findViewById(R.id.place_description)
        var ratingLabel: TextView = itemView.findViewById(R.id.rating)
    }
}