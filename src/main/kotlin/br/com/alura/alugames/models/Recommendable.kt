package br.com.alura.alugames.models

interface Recommendable {
    val mean: Double

    fun recommend(grade: Int)
}