package com.example.desafio_android.model

import com.google.gson.annotations.SerializedName


data class Owner(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val icone_usuario: String
)