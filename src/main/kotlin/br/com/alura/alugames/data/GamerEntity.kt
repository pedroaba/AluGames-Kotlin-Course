package br.com.alura.alugames.data

import br.com.alura.alugames.enums.PlanType
import javax.persistence.*

@Entity
@Table(name = "gamers")
open class GamerEntity(
    val name: String = "Name",
    val email: String = "E-mail",
    val dateOfBirth: String = "DateOfBirth",
    val user: String = "User",
    @ManyToOne
    val plan: PlanEntity = SeparatedPlanEntity(),
    @Id val internalId: String = ""
)