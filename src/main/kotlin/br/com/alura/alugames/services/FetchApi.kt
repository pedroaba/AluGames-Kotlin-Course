package br.com.alura.alugames.services

import br.com.alura.alugames.models.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class FetchApi {
    fun fetchGame(id: String): InfoGame {
        val apiUrl = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()
        val game = gson.fromJson(json, InfoGame::class.java)

        return game
    }
}