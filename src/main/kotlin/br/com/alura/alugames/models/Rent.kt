package br.com.alura.alugames.models


data class Rent(val gamer: Gamer, val game: Game, val period: Period, val id: Int = 0) {
    val rentValue = gamer.plan.calc(this)

    override fun toString(): String {
        return "Aluguel do ${game.title} por ${gamer.name} pelo valor R$ $rentValue"
    }
}
