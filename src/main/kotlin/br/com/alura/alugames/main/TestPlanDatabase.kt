package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.PlanDAO
import br.com.alura.alugames.enums.PlanType
import br.com.alura.alugames.models.SeparatePlan
import br.com.alura.alugames.models.SignedPlan

fun main() {
    val separated = SeparatePlan(PlanType.BRONZE)
    val silver = SignedPlan(PlanType.SILVER, 0.0, 2, 0.0)
    val gold = SignedPlan(PlanType.GOLD, 0.0, 2, 0.0)
    val platinum = SignedPlan(PlanType.PLATINUM, 0.0, 2, 0.0)
    val diamond = SignedPlan(PlanType.DIAMOND, 0.0, 2, 0.0)

    val manager = Database.getEntityManager()

    try {
        val dao = PlanDAO(manager)

        dao.add(separated)
        dao.add(silver)
        dao.add(gold)
        dao.add(platinum)
        dao.add(diamond)

        val plans = dao.getList()
        println(plans)
    } finally {
        manager.close()
    }
}