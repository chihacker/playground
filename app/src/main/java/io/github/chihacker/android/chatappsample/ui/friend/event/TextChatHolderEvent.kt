package io.github.chihacker.android.chatappsample.ui.friend.event

import io.github.chihacker.android.chatappsample.ui.friend.ChatViewModel
import io.github.chihacker.android.chatappsample.ui.friend.holder.TextChatHolder
import io.github.chihacker.android.chatappsample.ui.friend.model.Chat

class TextChatHolderEvent(private val viewModel: ChatViewModel): TextChatHolder.TextChatHolderEvent {
    override fun onClickText(item: Chat.Text) {
        viewModel.onClickText(item)
    }
}