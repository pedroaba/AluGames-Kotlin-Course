package br.com.alura.alugames.utils

import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.models.InfoGamerJson

fun InfoGamerJson.toGamer(): Gamer {
    return Gamer(this.name, this.email, this.dateOfBirth, this.user)
}