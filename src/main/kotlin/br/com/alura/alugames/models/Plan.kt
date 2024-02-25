package br.com.alura.alugames.models

import br.com.alura.alugames.enums.PlanType

sealed class Plan(val type: PlanType) {
    open fun calc(rent: Rent): Double {
        return (rent.game.price!! * rent.period.inDays).toDouble()
    }
}
