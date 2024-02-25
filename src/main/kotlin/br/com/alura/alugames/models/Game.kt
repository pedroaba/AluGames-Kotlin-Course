package br.com.alura.alugames.models

import com.google.gson.annotations.Expose

data class Game(
    @Expose() private val title: String,
    @Expose() private val thumbnail: String
) {
    private var description: String? = null
    var price: Float? = null

    override fun toString(): String {
        return "br.com.alura.alugames.models.Game(title='$title', thumbnail='$thumbnail', description='$description')"
    }

    fun setDescription(newDescription: String) {
        description = newDescription
    }

    fun getTitle(): String {
        return title
    }
}