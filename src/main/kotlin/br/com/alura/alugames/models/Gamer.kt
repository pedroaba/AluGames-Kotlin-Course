package br.com.alura.alugames.models

import br.com.alura.alugames.enums.PlanType
import java.time.Month
import java.util.*
import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendable {
    var dateOfBirth: String? = null
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
    val rentGames = mutableListOf<Rent>()

    var plan: Plan = SeparatePlan(PlanType.BRONZE)

    private val listGrades = mutableListOf<Int>()

    val recommendedGames = mutableListOf<Game>()

    override val mean: Double
        get() = listGrades.average()

    override fun recommend(grade: Int) {
        listGrades.add(grade)
    }

    fun recommendGame(game: Game, grade: Int) {
        recommend(grade)
        recommendedGames.add(game)
    }

    init {
        this.email = validateEmail()

        if (name.isEmpty()) {
            throw IllegalArgumentException("Nome está em branco.")
        }
    }

    constructor(name: String, email: String, dateOfBirth: String, user: String) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.user = user
        generateInternalId()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth=$dateOfBirth, user=$user, internalId=$internalId, searchedGames: $searchedGames, reputation: $mean)"
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

    fun rentGame(game: Game, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentGames.add(rent)

        return rent
    }

    fun gamesInMonth(month: Int): List<Game> {
        return rentGames
            .filter { rent -> rent.period.startDate.month == Month.of(month) }
            .map { rent: Rent -> rent.game }
    }

    companion object {
        fun createGamer(read: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = read.nextLine()

            println("Digite seu e-mail:")
            val email = read.nextLine()

            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = read.nextLine()

            if (option.equals("S", ignoreCase = true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val dateOfBirth = read.nextLine()

                println("Digite seu nome de usuário:")
                val user = read.nextLine()

                return Gamer(name, email, dateOfBirth, user)
            }

            return Gamer(name, email)
        }
    }
}
