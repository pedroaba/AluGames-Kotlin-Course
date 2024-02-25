package br.com.alura.alugames.main

import br.com.alura.alugames.enums.PlanType
import br.com.alura.alugames.models.Period
import br.com.alura.alugames.models.SignedPlan
import br.com.alura.alugames.services.FetchApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val fetchApi = FetchApi()
    val listOfGamers = fetchApi.fetchGamers()
    val listOfGames = fetchApi.fetchGames()

    val gamerCaroline = listOfGamers[3]
    val residentEvilVillage = listOfGames[10]
    val spiderMan = listOfGames[13]
    val theLastOfUs = listOfGames[2]
    val dandara = listOfGames[5]
    val assassins = listOfGames[4]
    val cyber = listOfGames[6]
    val god = listOfGames[7]
    val skyrim = listOfGames[18]

    val period = Period(LocalDate.now(), LocalDate.now().plusDays(7))

    gamerCaroline.rentGame(residentEvilVillage, period)
    gamerCaroline.rentGame(spiderMan, period)
    gamerCaroline.rentGame(theLastOfUs, period)

    val gamerGuilherme = listOfGamers[2]
    gamerGuilherme.plan = SignedPlan(PlanType.SILVER, 9.90, 3, 0.15)

    gamerGuilherme.rentGame(residentEvilVillage, period)
    gamerGuilherme.rentGame(spiderMan, period)
    gamerGuilherme.rentGame(theLastOfUs, period)
    gamerGuilherme.rentGame(theLastOfUs, period)

    gamerGuilherme.recommend(7)
    gamerGuilherme.recommend(10)
    gamerGuilherme.recommend(8)

    gamerGuilherme.rentGame(residentEvilVillage, period)

    gamerGuilherme.recommendGame(theLastOfUs, 7)
    gamerGuilherme.recommendGame(residentEvilVillage, 10)

    gamerCaroline.recommendGame(theLastOfUs, 8)
    gamerCaroline.recommendGame(residentEvilVillage, 9)

    gamerGuilherme.recommendGame(residentEvilVillage, 7)
    gamerGuilherme.recommendGame(theLastOfUs, 10)
    gamerGuilherme.recommendGame(assassins, 8)
    gamerGuilherme.recommendGame(cyber, 7)
    gamerGuilherme.recommendGame(god, 10)
    gamerGuilherme.recommendGame(dandara, 8)
    gamerGuilherme.recommendGame(skyrim, 8)
    gamerGuilherme.recommendGame(spiderMan, 6)

    val gsonBuilder = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gsonBuilder.toJson(gamerGuilherme.recommendedGames)

    val gamerNameFormatted = gamerGuilherme.name.lowercase().replace("\\s*", "-")
    val file = File("recommended-games-of-$gamerNameFormatted-${LocalDate.now().toEpochDay()}.json")
    file.writeText(serialization)

    println(file.absolutePath)
}