package br.com.alura.alugames.models

data class Game(private val title: String, private val thumbnail: String) {
    private var description: String? = null

    override fun toString(): String {
        return "br.com.alura.alugames.models.Game(title='$title', thumbnail='$thumbnail', description='$description')"
    }

    fun setDescription(newDescription: String) {
        description = newDescription
    }

    fun getDescription(): String? {
        return description
    }

    fun getTitle(): String {
        return title
    }

    fun getThumbnail(): String {
        return thumbnail
    }
}