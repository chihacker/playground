package io.github.chihacker.android.chatappsample.ui.friend

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.github.chihacker.android.chatappsample.ui.friend.holder.ChatHolder
import io.github.chihacker.android.chatappsample.ui.friend.holder.ImageChatHolder
import io.github.chihacker.android.chatappsample.ui.friend.holder.TextChatHolder
import io.github.chihacker.android.chatappsample.ui.friend.model.Chat

class ChatAdapter(
    private val textChatAction: TextChatHolder.TextChatHolderEvent,
    private val imageChatAction: ImageChatHolder.ImageChatHolderEvent
): ListAdapter<Chat, ChatHolder<*, *>>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder<*, *> {
        return when (viewType) {
            TextChatHolder.ID -> TextChatHolder.from(parent)
            ImageChatHolder.ID -> ImageChatHolder.from(parent)
            else -> throw Exception("It is not a supported type.")
        }
    }

    override fun onBindViewHolder(holder: ChatHolder<*, *>, position: Int) {
        when (holder) {
            is TextChatHolder -> holder.onBind(getItem(position) as Chat.Text, textChatAction)
            is ImageChatHolder -> holder.onBind(getItem(position) as Chat.Image, imageChatAction)
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (getItem(position)) {
            is Chat.Text -> TextChatHolder.ID
            is Chat.Image -> ImageChatHolder.ID
        }
        return super.getItemViewType(position)
    }

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Chat>() {
            override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
                return try {
                    when(oldItem) {
                        is Chat.Text -> TextChatHolder.DIFF.areItemsTheSame(oldItem, newItem as Chat.Text)
                        is Chat.Image -> ImageChatHolder.DIFF.areItemsTheSame(oldItem, newItem as Chat.Image)
                    }
                } catch (e: Throwable) {
                    false
                }
            }

            override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
                return try {
                    when(oldItem) {
                        is Chat.Text -> TextChatHolder.DIFF.areContentsTheSame(oldItem, newItem as Chat.Text)
                        is Chat.Image -> ImageChatHolder.DIFF.areContentsTheSame(oldItem, newItem as Chat.Image)
                    }
                } catch (e: Throwable) {
                    false
                }
            }
        }
    }
}