package com.example.placesco.view.view.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.model.Sites
import java.security.AccessController.getContext

class AdapterPlaces(private val mSites: ArrayList<Sites>) : RecyclerView.Adapter<AdapterPlaces.ViewHolder>() {

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
        //val data = dataPlaces[position]
        val (urlPhoto, name, description, rating) = mSites[position]

        val imgUri: Uri = Uri.parse(urlPhoto)
        holder.imageLabel.setImageURI(imgUri)
        holder.nameLabel.text = name
        holder.descriptionLabel.text = description
        holder.ratingLabel.text = rating
        //holder.bind(data)
    }

    override fun getItemCount(): Int {
        return mSites.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /*val urlPhotoView = view.findViewById(R.id.image_perfil) as ImageView
        //val placeNameView = view.findViewById(R.id.place_name) as TextView
        val placeDescriptionView = view.findViewById(R.id.place_description) as TextView
        val ratingView = view.findViewById(R.id.rating) as TextView*/

        var imageLabel: ImageView = itemView.findViewById(R.id.image_perfil)
        var nameLabel: TextView = itemView.findViewById(R.id.place_name)
        var descriptionLabel: TextView = itemView.findViewById(R.id.place_description)
        var ratingLabel: TextView = itemView.findViewById(R.id.rating)

        /*fun bind(dataSites: Sites) {
            placeNameView.text = dataSites.name
            placeDescriptionView.text = dataSites.description
            ratingView.text = dataSites.rating

        }*/

    }


}