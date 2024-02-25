package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.GamerDAO
import br.com.alura.alugames.data.GamesDAO
import br.com.alura.alugames.data.RentDAO
import br.com.alura.alugames.models.Period

fun main() {
    val manager = Database.getEntityManager()

    val gameDAO = GamesDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val rentDAO = RentDAO(manager)

    try {
        val gamer = gamerDAO.getById("moni#1820")
        val game = gameDAO.getById(1)
        val rent = gamer.rentGame(game, Period())

        rentDAO.add(rent)

        val rents = rentDAO.getList()
        println(rents)
    } finally {
        manager.close()
    }
}