package br.com.alura.alugames.main

import br.com.alura.alugames.data.Database
import br.com.alura.alugames.data.GamesDAO
import br.com.alura.alugames.models.Game

fun main() {
    val manager = Database.getEntityManager()

    try {
        val dao = GamesDAO(manager)
        val game = Game(
            "Test", "alnasndkaslsnclas", 32.0, "ascdaslkndcasnclasnclas",
        )

//        dao.add(game)
        val gameFromDb = dao.getById(3)
        println(gameFromDb)

        dao.delete(3)

        val games: List<Game> = dao.getList()
        println(games)
    } finally {
        manager.close()
    }
}