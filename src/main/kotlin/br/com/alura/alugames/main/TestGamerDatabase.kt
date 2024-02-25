package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.GamerDAO
import br.com.alura.alugames.data.PlanDAO
import br.com.alura.alugames.models.Gamer

fun main() {
    val gamer = Gamer(
        "Monica",
        "monica@email.com",
        "15/03/1992",
        "moni"
    )

    val manager = Database.getEntityManager()
    val dao = GamerDAO(manager)
    val planDAO = PlanDAO(manager)

    try {
        gamer.plan = planDAO.getById(3)

        dao.add(gamer)

        val gamers = dao.getList()
        println(gamers)
    } finally {
        manager.close()
    }
}