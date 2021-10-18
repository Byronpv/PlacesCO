package com.example.placesco.view.view.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.placesco.R
import com.example.placesco.viewmodel.SiteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {
    private lateinit var model: SiteViewModel
    private lateinit var title: TextView
    private lateinit var image: ImageView
    private lateinit var description: TextView
    private lateinit var rating: TextView
    private lateinit var location: TextView
    private lateinit var temperature: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.textpoi1)
        image = view.findViewById(R.id.imageView)
        description = view.findViewById(R.id.textinfo)
        rating = view.findViewById(R.id.ratingtext)
        location = view.findViewById(R.id.textlocate)
        temperature = view.findViewById(R.id.textweather)
        model = ViewModelProvider(requireActivity()).get(SiteViewModel::class.java)
        observeLiveData()

        val button = view.findViewById<FloatingActionButton>(R.id.locate)
        button.setOnClickListener {
            val uri = Uri.parse("geo: ${location.text}?z:15")
            val locationIntent = Intent(Intent.ACTION_VIEW, uri)
            locationIntent.setPackage("com.google.android.apps.maps")
            startActivity(locationIntent)

        }
    }

    private fun observeLiveData() {
        model.getSelected().observe(viewLifecycleOwner, { site ->
            title.text = site.name
            Picasso.get().load(site.urlPhoto).into(image)
            description.text = site.description
            rating.text = site.rating
            location.text = site.location
            temperature.text = site.temperature
        })
    }
}
