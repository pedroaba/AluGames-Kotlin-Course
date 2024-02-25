package br.com.alura.alugames.utils

import br.com.alura.alugames.data.GamerEntity
import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.models.InfoGamerJson

fun InfoGamerJson.toGamer(): Gamer {
    return Gamer(this.name, this.email, this.dateOfBirth, this.user)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(
        this.name,
        this.email,
        this.dateOfBirth ?: "",
        this.user ?: "",
        this.plan.toEntity(),
        this.internalId ?: ""
    )
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        this.name,
        this.email,
        this.dateOfBirth,
        this.user,
        this.internalId
    )
}
