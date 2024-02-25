package br.com.alura.alugames.models

import com.google.gson.annotations.Expose
import kotlin.random.Random


data class Game(
    @Expose() val title: String, @Expose() val thumbnail: String
) {
    var description: String? = null
    var price: Double = 0.0
    var id: Int = Random.nextInt(1_000_000)

    constructor(title: String, thumbnail: String, price: Double, description: String?, id: Int = 0) : this(
        title, thumbnail
    ) {
        this.price = price
        this.description = description
        this.id = id
    }

    override fun toString(): String {
        return "br.com.alura.alugames.models.Game(title='$title', thumbnail='$thumbnail', description='$description')"
    }
}