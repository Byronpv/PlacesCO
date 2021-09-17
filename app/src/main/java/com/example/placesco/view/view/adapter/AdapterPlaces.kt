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

class AdapterPlaces : RecyclerView.Adapter<AdapterPlaces.ViewHolder>() {

    private var dataPlaces: MutableList<Sites> = ArrayList()
    lateinit var context: Context

    fun setListData(data: ArrayList<Sites>) {
        this.dataPlaces = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sites_description, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataPlaces[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataPlaces.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val urlPhotoView = view.findViewById(R.id.image_perfil) as ImageView
        val placeNameView = view.findViewById(R.id.place_name) as TextView
        val placeDescriptionView = view.findViewById(R.id.place_description) as TextView
        val ratingView = view.findViewById(R.id.rating) as TextView

        fun bind(dataSites: Sites) {
            placeNameView.text = dataSites.name
            placeDescriptionView.text = dataSites.description
            ratingView.text = dataSites.rating

        }

    }
}