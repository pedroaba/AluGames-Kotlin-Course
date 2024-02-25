package br.com.alura.alugames.data

import br.com.alura.alugames.models.Rent
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager) : DAO<Rent, RentEntity> (manager, RentEntity::class.java) {
    override fun toEntity(target: Rent): RentEntity {
        return RentEntity(
            target.gamer.toEntity(),
            target.game.toEntity(),
            target.period,
        ).apply {
            rentValue = target.rentValue
            id = target.id
        }
    }

    override fun toModel(entity: RentEntity): Rent {
        return Rent(
            entity.gamer.toModel(),
            entity.game.toModel(),
            entity.period,
            entity.id
        )
    }
}