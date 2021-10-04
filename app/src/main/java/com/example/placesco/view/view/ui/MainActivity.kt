package com.example.placesco.view.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placesco.R
import com.example.placesco.view.view.adapter.AdapterPlaces
import com.example.placesco.model.Sites
import com.example.poi.ClickListener
import org.json.JSONArray
import java.io.IOException
import java.util.ArrayList
import org.json.JSONException

class MainActivity : AppCompatActivity(), ClickListener {
    private lateinit var recycler: RecyclerView
    private lateinit var adapterPlaces: AdapterPlaces
    private lateinit var mSites: ArrayList<Sites>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_details)
    /*    recycler = findViewById(R.id.recyclerview_places)
        recycler.layoutManager = LinearLayoutManager(this)
        setupRecyclerView()
        generateSites() */
    }

   private fun setupRecyclerView() {
        mSites = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        adapterPlaces = AdapterPlaces(mSites, this)
        recycler.adapter = adapterPlaces
    }

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
                mSites.add(sites)
            }
            adapterPlaces.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    override fun onItemClicked(position: Int) {
        Toast.makeText(this, "POI " + (position + 1) + " clickeado", Toast.LENGTH_SHORT).show()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val newFragment = DetailsFragment()
        transaction.replace(R.id.lhome, newFragment).addToBackStack(null).commit()
    }
}