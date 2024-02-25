package br.com.alura.alugames.data

import br.com.alura.alugames.models.Game
import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity> (protected val manager: EntityManager, protected val entityType: Class<TEntity>) {
    abstract fun toEntity(target: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getList(): List<TModel> {
        val query = manager.createQuery("from ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun add(objectToAdd: TModel) {
        val entity = toEntity(objectToAdd)

        manager.transaction.begin()
        manager.persist(entity)

        manager.transaction.commit()
    }

    open fun getById(id: Int): TModel {
        val query = manager.createQuery("from ${entityType.simpleName} where id=:id", entityType)
        query.setParameter("id", id)

        val entity = query.singleResult

        return toModel(entity)
    }

    open fun delete(id: Int) {
        val query = manager.createQuery("from ${entityType.simpleName} where id=:id", entityType)
        query.setParameter("id", id)

        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)

        manager.transaction.commit()
    }
}
