package br.com.alura.alugames.models


data class Rent(val gamer: Gamer, val game: Game, val period: Period) {
    private val rentValue = gamer.plan.calc(this)

    override fun toString(): String {
        return "Aluguel do ${game.getTitle()} por ${gamer.name} pelo valor R$ $rentValue"
    }
}
