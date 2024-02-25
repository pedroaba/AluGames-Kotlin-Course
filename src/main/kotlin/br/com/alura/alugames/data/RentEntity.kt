package br.com.alura.alugames.data

import br.com.alura.alugames.models.Period
import javax.persistence.*

@Entity
@Table (name = "rents")
open class RentEntity (
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: Period
) {
    var rentValue = 0.0

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}