package br.com.alura.alugames.models

data class InfoGame(private val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }

    fun title(): String {
        return info.title
    }

    fun thumb(): String {
        return info.thumb
    }
}