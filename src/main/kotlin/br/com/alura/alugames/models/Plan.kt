package br.com.alura.alugames.models

import br.com.alura.alugames.enums.PlanType

sealed class Plan(val type: PlanType, val id: Int = 0) {
    open fun calc(rent: Rent): Double {
        return (rent.game.price * rent.period.inDays).toDouble()
    }
}
