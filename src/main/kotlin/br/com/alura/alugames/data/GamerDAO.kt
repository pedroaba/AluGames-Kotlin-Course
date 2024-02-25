package br.com.alura.alugames.data

import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager): DAO<Gamer, GamerEntity> (manager, GamerEntity::class.java) {
    override fun toEntity(target: Gamer): GamerEntity {
        return target.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel()
    }

    fun getById(id: String): Gamer {
        val query = manager.createQuery("from ${entityType.simpleName} where internalId=:internalId", entityType)
        query.setParameter("internalId", id)

        val entity = query.singleResult

        return toModel(entity)
    }
}