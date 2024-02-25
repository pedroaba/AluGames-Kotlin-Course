package br.com.alura.alugames.utils

import br.com.alura.alugames.data.PlanEntity
import br.com.alura.alugames.data.SeparatedPlanEntity
import br.com.alura.alugames.data.SignedPlanEntity
import br.com.alura.alugames.models.Plan
import br.com.alura.alugames.models.SeparatePlan
import br.com.alura.alugames.models.SignedPlan

fun Plan.toEntity(): PlanEntity {
    return if (this is SignedPlan) {
        SignedPlanEntity(
            this.type,
            this.monthlyPayment,
            this.includedGames,
            this.reputationDiscountPercentage,
            this.id
        )
    } else {
        SeparatedPlanEntity(this.type, this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SignedPlanEntity) {
        SignedPlan(
            this.type,
            this.monthlyPayment,
            this.includedGames,
            this.reputationDiscountPercentage,
            this.id
        )
    } else {
        SeparatePlan(this.type, this.id)
    }
}