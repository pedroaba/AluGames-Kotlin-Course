package br.com.alura.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.toAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateOfBirth = LocalDate.parse(this, formatter)
    val now = LocalDate.now()

    return Period.between(dateOfBirth, now).years
}
