package com.example.placesco.view.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.view.view.adapter.AdapterPlaces
import com.example.placesco.model.Sites
import org.json.JSONArray
import java.io.IOException
import java.util.ArrayList
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    private val siteList: ArrayList<Sites> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var adapterPlaces: AdapterPlaces
    private lateinit var mSites: ArrayList<Sites>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //adapterPlaces = AdapterPlaces(mSites)
        recycler = findViewById(R.id.recyclerview_places)
        recycler.layoutManager = LinearLayoutManager(this)
        //adapterPlaces.setListData(createPlaces())
        setupRecyclerView()
        generateSites()
        //recycler.adapter = adapterPlaces
    }

    /*Se configura el recyclerview*/
    private fun setupRecyclerView() {
        mSites = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        adapterPlaces = AdapterPlaces(mSites)
        recycler.adapter = adapterPlaces
    }

    /*funcion que permite leer el archivo json con los sitios de interés*/
    private fun readJsonFile(): String? {
        var sitesString: String? = null
        try {
            val inputStream = assets.open("mock_sites.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            sitesString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return sitesString
    }

    /*funcion que almacena los datos del json para reflejarlos en el layout*/
    private fun generateSites() {
        val sitesString = readJsonFile()
        try {
            val sitesJson = JSONArray(sitesString)
            for (i in 0 until sitesJson.length()) {
                val sitesJson = sitesJson.getJSONObject(i)
                val sites = Sites(
                    sitesJson.getString("urlPhoto"),
                    sitesJson.getString("name"),
                    sitesJson.getString("description"),
                    sitesJson.getString("rating")
                )
                //Log.d(TAG, "generateSites: $sites")
                mSites.add(sites)
            }

            adapterPlaces.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


    private fun createPlaces(): ArrayList<Sites> {
        return arrayListOf(Sites("", "Cartagena", "Ciudad amurallada", "4.8"),
            Sites("", "Cartagena", "Ciudad amurallada", "4.8"),
            Sites("", "Cartagena", "Ciudad amurallada", "4.8"))
    }
}