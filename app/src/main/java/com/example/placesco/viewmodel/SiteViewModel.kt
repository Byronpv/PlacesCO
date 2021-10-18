package com.example.placesco.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.placesco.model.Sites
import com.example.placesco.remotedata.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SiteViewModel : ViewModel() {
    val retrofitService = RetrofitFactory.apiService()
    val sites = MutableLiveData<List<Sites>>()

    init {
        getAllSites()
    }

    fun getSites() : LiveData<List<Sites>> = sites

    private fun getAllSites() {
        retrofitService.requestSites().enqueue(object : Callback<List<Sites>> {
            override fun onResponse(call: Call<List<Sites>>, response: Response<List<Sites>>) {
                sites.value = (response.body() as List<Sites>)
            }

            override fun onFailure(call: Call<List<Sites>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private val selected = MutableLiveData<Sites>()

    fun getSelected() : LiveData<Sites> = selected

    fun select(site: Sites) {
        selected.value = site
    }
}