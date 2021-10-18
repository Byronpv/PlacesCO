package com.example.placesco.view.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.model.Sites
import com.example.placesco.view.view.adapter.AdapterPlaces
import com.example.placesco.viewmodel.SiteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(), ClickListener {

    private lateinit var adapterPlaces: AdapterPlaces
    lateinit var layoutManager: LinearLayoutManager
    lateinit var sitesList: RecyclerView
    private lateinit var model: SiteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        sitesList = view.findViewById(R.id.recyclerview_places)

        layoutManager = LinearLayoutManager(requireContext())
        sitesList.layoutManager = layoutManager

        model = ViewModelProvider(requireActivity()).get(SiteViewModel::class.java)
        model.getSites().observe(viewLifecycleOwner, Observer {
            adapterPlaces = AdapterPlaces(requireActivity().baseContext, it, this as ClickListener)
            adapterPlaces.notifyDataSetChanged()
            sitesList.adapter = adapterPlaces
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: FloatingActionButton = view.findViewById(R.id.button)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
    }

    override fun onItemClicked(position: Int, sites: Sites) {
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
        model = ViewModelProvider(requireActivity()).get(SiteViewModel::class.java)
        model.select(sites)
    }
}