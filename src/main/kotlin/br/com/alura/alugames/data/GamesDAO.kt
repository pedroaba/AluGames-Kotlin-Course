package br.com.alura.alugames.data

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager) : DAO<Game, GameEntity> (manager, GameEntity::class.java) {
    override fun toEntity(target: Game): GameEntity {
        return target.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }
}