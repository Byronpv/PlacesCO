package com.example.placesco.remotedata

import android.telecom.Call
import com.example.placesco.model.Sites
import retrofit2.http.GET

interface ApiService {
    @GET("sites")
    fun requestSites(): retrofit2.Call<List<Sites>>
}