package br.com.alura.alugames.models

import br.com.alura.alugames.enums.PlanType

class SignedPlan(
    type: PlanType,
    val monthlyPayment: Double,
    val includedGames: Int,
    val reputationDiscountPercentage: Double,
    id: Int = 0
) : Plan(type, id) {
    override fun calc(rent: Rent): Double {
        val totalOfGamesOnMonth = rent.gamer.gamesInMonth(rent.period.startDate.monthValue).size + 1

        return if (totalOfGamesOnMonth <= includedGames) {
            0.0
        } else {
            val originalValue = super.calc(rent)
            if (rent.gamer.mean > 8) {
                originalValue - (originalValue * reputationDiscountPercentage)
            } else {
                originalValue
            }
        }
    }
}