package br.com.alura.alugames.models

import com.google.gson.annotations.SerializedName


data class InfoGameJson(
    @SerializedName("titulo") val title: String,
    @SerializedName("capa") val thumb: String,
    @SerializedName("preco") val price: Float,
    @SerializedName("descricao") val description: String,
)
