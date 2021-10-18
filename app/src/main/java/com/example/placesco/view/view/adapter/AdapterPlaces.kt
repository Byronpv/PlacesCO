package com.example.placesco.view.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.model.Sites
import com.example.placesco.view.view.ui.ClickListener
import com.squareup.picasso.Picasso

class AdapterPlaces(
    private val context : Context,
    private var sites : List<Sites>,
    val clickListener : ClickListener
) : RecyclerView.Adapter<AdapterPlaces.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sites_description, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = sites[position]
        holder.nameLabel.text = sites[position].name
        holder.descriptionLabel.text = sites[position].description
        holder.ratingLabel.text = sites[position].rating
        Picasso.get().load(sites[position].urlPhoto).into(holder.imageLabel)

        val listener = holder.imageLabel
        val listener2 = holder.descriptionLabel
        val listener3 = holder.ratingLabel
        val listener4 = holder.nameLabel
        listener.setOnClickListener {
            clickListener.onItemClicked(position, item)
        }
        listener2.setOnClickListener {
            clickListener.onItemClicked(position, item)
        }
        listener3.setOnClickListener {
            clickListener.onItemClicked(position, item)
        }
        listener4.setOnClickListener {
            clickListener.onItemClicked(position, item)
        }
    }

    override fun getItemCount(): Int {
        return sites.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageLabel: ImageView = itemView.findViewById(R.id.image_profile)
        var nameLabel: TextView = itemView.findViewById(R.id.place_name)
        var descriptionLabel: TextView = itemView.findViewById(R.id.place_description)
        var ratingLabel: TextView = itemView.findViewById(R.id.rating)
    }
}