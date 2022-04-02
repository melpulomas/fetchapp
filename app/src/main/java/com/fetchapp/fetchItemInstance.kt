package com.fetchapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object fetchItemInstance {

    val api: fetchItemAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(fetchItemAPI::class.java)
    }
}