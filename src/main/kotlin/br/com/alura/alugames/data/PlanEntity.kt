package br.com.alura.alugames.data

import br.com.alura.alugames.enums.PlanType
import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PlanType", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val type: PlanType = PlanType.BRONZE,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open var id: Int = 0,
)

@Entity
@DiscriminatorValue("separated")
open class SeparatedPlanEntity(
    type: PlanType = PlanType.BRONZE,
    id: Int = 0,
) : PlanEntity(type, id)

@Entity
@DiscriminatorValue("signed")
open class SignedPlanEntity(
    type: PlanType = PlanType.BRONZE,
    val monthlyPayment: Double = 0.0,
    val includedGames: Int = 0,
    val reputationDiscountPercentage: Double = 0.0,
    id: Int = 0,
) : PlanEntity(type, id)
