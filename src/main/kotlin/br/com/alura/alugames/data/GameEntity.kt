package br.com.alura.alugames.data

import javax.persistence.*

@Entity
@Table(name = "jogos")
open class GameEntity(
    val title: String = "Title",
    val thumbnail: String = "Thumb",
    val price: Double = 0.0,
    val description: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int = 0
)