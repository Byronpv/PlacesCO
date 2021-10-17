package com.example.placesco.remotedata

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private const val BASE_URL = "https://6166413b13aa1d00170a6442.mockapi.io/"

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun apiService(): ApiService = retrofit().create(ApiService::class.java)
}