package br.com.alura.alugames.models

import br.com.alura.alugames.enums.PlanType

class SeparatePlan(type: PlanType) : Plan(type) {
    override fun calc(rent: Rent): Double {
        val originalValue = super.calc(rent)

        return if (rent.gamer.mean > 8) {
            originalValue - (originalValue * 0.1)
        } else {
            originalValue
        }
    }
}