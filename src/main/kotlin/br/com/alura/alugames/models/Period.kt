package br.com.alura.alugames.models

import java.time.LocalDate
import java.time.Period

data class Period(val startDate: LocalDate, val endDate: LocalDate) {
    val inDays = Period.between(startDate, endDate).days
}
