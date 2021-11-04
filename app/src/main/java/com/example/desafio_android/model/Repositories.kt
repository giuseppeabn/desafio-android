package com.example.desafio_android.model


import com.google.gson.annotations.SerializedName

data class Repositories(
    @SerializedName("items") val items: List<Repository>
)
