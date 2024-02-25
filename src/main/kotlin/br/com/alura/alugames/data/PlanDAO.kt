package br.com.alura.alugames.data

import br.com.alura.alugames.models.Plan
import br.com.alura.alugames.models.SignedPlan
import br.com.alura.alugames.models.SeparatePlan
import br.com.alura.alugames.utils.toEntity
import br.com.alura.alugames.utils.toModel
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager) : DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }

    override fun toEntity(target: Plan): PlanEntity {
        return target.toEntity()
    }
}