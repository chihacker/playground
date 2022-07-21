package io.github.chihacker.android.chatappsample.ui.friend.model

sealed class Chat {

    abstract val id: String

    data class Text(
        override val id: String,
        val text: String
    ): Chat()

    data class Image(
        override val id: String,
        val url: String
    ): Chat()
}