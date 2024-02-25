package br.com.alura.alugames.utils

import br.com.alura.alugames.data.GameEntity
import br.com.alura.alugames.models.Game
import br.com.alura.alugames.models.InfoGameJson

fun InfoGameJson.toGame(): Game {
    val game = Game(this.title, this.thumb)
    game.description = this.description
    game.price = this.price.toDouble()

    return game
}

fun Game.toEntity(): GameEntity {
    return GameEntity(
        this.title,
        this.thumbnail,
        this.price,
        this.description
    )
}

fun GameEntity.toModel(): Game {
    return Game(
        this.title,
        this.thumbnail,
        this.price,
        this.description
    )
}
