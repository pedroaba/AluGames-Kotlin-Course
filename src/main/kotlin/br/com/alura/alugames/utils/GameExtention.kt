package br.com.alura.alugames.utils

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.models.InfoGameJson

fun InfoGameJson.toGame(): Game {
    val game = Game(this.title, this.thumb)
    game.setDescription(this.description)
    game.price = this.price

    return game
}