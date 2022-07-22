package io.github.chihacker.android.chatappsample.domain.dto

data class FriendDto(
    val id: String,
    val type: Type,
    val profileUrl: String,
    val name: String
) {
    enum class Type {
        FRIEND, FAVORITE, RECOMMEND
    }
}