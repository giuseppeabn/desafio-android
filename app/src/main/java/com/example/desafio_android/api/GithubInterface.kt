package com.example.desafio_android.api

import com.example.desafio_android.model.PullRequest
import com.example.desafio_android.model.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubInterface {
    @GET("search/repositories?q=language:Java&sort=stars")
    fun reposList(@Query("page") page: Int): Call<Repositories>

    @GET("repos/{owner}/{repositorio}/pulls")
    fun getPullRequests(
        @Path("owner") owner: String,
        @Path("repositorio") repositorio: String
    ): Call<List<PullRequest>>
}
