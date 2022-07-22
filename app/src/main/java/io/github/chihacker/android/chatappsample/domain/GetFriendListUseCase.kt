package io.github.chihacker.android.chatappsample.domain

import io.github.chihacker.android.chatappsample.data.FriendRepository
import io.github.chihacker.android.chatappsample.domain.dto.FriendDto

class GetFriendListUseCase(
    private val friendRepository: FriendRepository
) {

    fun invoke(): Output {
        val friend = friendRepository.getFriendList()
        val favorite = friendRepository.getFavoriteList()
        val recommend = friendRepository.getRecommendList()

        val list = mutableListOf<FriendDto>()

        friend.forEach {
            list.add(
                FriendDto(
                    id = it.id,
                    name = it.name,
                    profileUrl = it.profileUrl,
                    type = FriendDto.Type.FRIEND
                )
            )
        }

        return Output(
            list
        )

    }

    data class Output(
        val friends: List<FriendDto>
    )
}