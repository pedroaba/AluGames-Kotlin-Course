package br.com.alura.alugames.main

import br.com.alura.alugames.models.Gamer

fun main() {
    val gamer1 = Gamer("Jaque", "jacque@email.com")
    val gamer2 = Gamer("Jeni", "jeni@email.com", "19/19/1992", "keiii")

    println(gamer1)
    println(gamer2)

    gamer1.let {
        it.breathDay = "18/09/2000"
        it.user = "jacqueskywalker"
    }.also {
        println(gamer1.internalId)
    }

    println(gamer1)
}