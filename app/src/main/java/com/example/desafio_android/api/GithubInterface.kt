package com.example.desafio_android.api

import com.example.desafio_android.model.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubInterface {
    @GET("search/repositories?q=language:Java&sort=stars")
    fun reposList(@Query("page") page: Int): Call<Repositories>
}
