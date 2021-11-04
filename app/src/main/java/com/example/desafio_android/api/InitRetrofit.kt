package com.example.desafio_android.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object InitRetrofit {

    const val BASE_URL = "https://api.github.com/"

    fun init(): GithubInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubInterface::class.java)
    }
}