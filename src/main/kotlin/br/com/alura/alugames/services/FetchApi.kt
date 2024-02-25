package br.com.alura.alugames.services

import br.com.alura.alugames.models.*
import br.com.alura.alugames.utils.toGamer
import br.com.alura.alugames.utils.toGame
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class FetchApi {
    private fun fetch(uri: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun fetchGame(id: String): InfoGame {
        val apiUrl = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = fetch(apiUrl)

        val gson = Gson()
        val game = gson.fromJson(json, InfoGame::class.java)

        return game
    }

    fun fetchGames(): List<Game> {
        val apiUrl = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = fetch(apiUrl)

        val gson = Gson()

        val myGameType = object : TypeToken<List<InfoGameJson>>() {}.type
        val listInfoGames: List<InfoGameJson> = gson.fromJson(json, myGameType)

        val games = listInfoGames.map {
            infoGame -> infoGame.toGame()
        }

        return games
    }

    fun fetchGamers(): List<Gamer> {
        val apiUrl = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = fetch(apiUrl)

        val gson = Gson()

        val myGamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listInfoGamers: List<InfoGamerJson> = gson.fromJson(json, myGamerType)

        val listGamers = listInfoGamers.map {
            infoGamerJson -> infoGamerJson.toGamer()
        }

        return listGamers
    }
}