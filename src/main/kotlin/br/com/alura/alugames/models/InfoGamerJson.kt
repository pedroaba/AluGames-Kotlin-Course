package br.com.alura.alugames.models

import com.google.gson.annotations.SerializedName

data class InfoGamerJson(
    @SerializedName("nome") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("dataNascimento") val dateOfBirth: String,
    @SerializedName("usuario") val user: String
)
