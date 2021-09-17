package com.example.placesco.view.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.view.view.adapter.AdapterPlaces
import com.example.placesco.model.Sites

class MainActivity : AppCompatActivity() {
    private val siteList: ArrayList<Sites> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var adapterPlaces: AdapterPlaces
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapterPlaces = AdapterPlaces()
        recycler = findViewById(R.id.recyclerview_places)
        recycler.layoutManager = LinearLayoutManager(this)
        adapterPlaces.setListData(createPlaces())
        recycler.adapter = adapterPlaces
    }


    private fun createPlaces(): ArrayList<Sites> {
        return arrayListOf(Sites("", "Cartagena", "Ciudad amurallada", "4.8"),
            Sites("", "Cartagena", "Ciudad amurallada", "4.8"),
            Sites("", "Cartagena", "Ciudad amurallada", "4.8"))
    }
}