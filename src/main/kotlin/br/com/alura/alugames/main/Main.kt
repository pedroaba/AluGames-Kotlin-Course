package br.com.alura.alugames.main

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.services.FetchApi
import br.com.alura.alugames.utils.toAge
import java.util.*


fun main() {
    val read = Scanner(System.`in`)
    val gamer = Gamer.createGamer(read)
    println("Cadastro concluído com sucesso. Dados do gamer:")
    println(gamer)

    println("Idade do gamer '${gamer.name}': ${gamer.dateOfBirth?.toAge()}")

    do {
        println("Digite um código do jogo para buscar: ")
        val search = read.nextLine()

        val fetchApi = FetchApi()
        val infoGame = fetchApi.fetchGame(search)

        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(infoGame.title(), infoGame.thumb())
        }

        result.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        result.onSuccess {
            println("Deseja inserir uma descrição personalizada? (S/N) ")
            val option = read.nextLine()

            if (option.equals("S", ignoreCase = true)) {
                println("Insira a descrição personalizada para o jogo '${infoGame.title()}': ")
                val description = read.nextLine()

                if (description.isNullOrEmpty()) {
                    myGame?.setDescription(myGame?.getTitle()!!)
                } else {
                    myGame?.setDescription(description)
                }
            }

            gamer.searchedGames.add(myGame!!)
        }

        println("Deseja buscar um novo jogo? (S/n)")
        val response = read.nextLine()
    } while (response.equals("s", ignoreCase = true))

    println("Jogos buscados:")
    println(gamer.searchedGames)

    println("\n Jogos ordenados por título: ")
    gamer.searchedGames.sortBy {
        it.getTitle()
    }

    gamer.searchedGames.forEach {
        println("Título: ${it.getTitle()}")
    }

    val gamesFiltered = gamer.searchedGames.filter {
        it.getTitle().contains("batman", ignoreCase = true)
    }

    println("\n Jogos Filtrados:")
    println(gamesFiltered)

    println("Deseja excluir algum jogo da lista original? (S/N)")
    val option = read.nextLine()
    if (option.equals("s", ignoreCase = true)) {
        println(gamer.searchedGames)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val position = read.nextInt()

        gamer.searchedGames.removeAt(position)
    }

    println("\n Lista Atualizada:")
    println(gamer.searchedGames)

    println("Busca finalizada com sucesso.")
}