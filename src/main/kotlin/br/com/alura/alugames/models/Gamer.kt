package br.com.alura.alugames.models

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var breathDay: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrEmpty()) {
                generateInternalId()
            } else {
                generateInternalId(replaceUserId = true)
            }
        }

    var internalId: String? = null
        private set

    val searchedGames = mutableListOf<Game>()

    init {
        this.email = validateEmail()

        if (name.isEmpty()) {
            throw IllegalArgumentException("Nome está em branco.")
        }
    }

    constructor(name: String, email: String, breathDay: String, user: String): this(name, email) {
        this.breathDay = breathDay
        this.user = user
        generateInternalId()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', breathDay=$breathDay, user=$user, internalId=$internalId, searchedGames: $searchedGames)"
    }

    private fun generateInternalId(replaceUserId: Boolean = false) {
        if (replaceUserId) {
            val numberOfId = internalId!!.split("#").last()
            internalId = "$user#$numberOfId"
            return
        }

        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internalId = "$user#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)) {
            return email
        }

        throw IllegalArgumentException("E-mail inválido.")
    }

    companion object {
        fun  createGamer(read: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = read.nextLine()

            println("Digite seu e-mail:")
            val email = read.nextLine()

            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = read.nextLine()

            if (option.equals("S", ignoreCase = true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val breathDay = read.nextLine()

                println("Digite seu nome de usuário:")
                val user = read.nextLine()

                return Gamer(name, email, breathDay, user)
            }

            return Gamer(name, email)
        }
    }
}
