package io.github.chihacker.android.chatappsample.ui.friend.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import io.github.chihacker.android.chatappsample.R
import io.github.chihacker.android.chatappsample.databinding.ItemChatTextBinding
import io.github.chihacker.android.chatappsample.ui.friend.model.Chat

class TextChatHolder(view: View): ChatHolder<Chat.Text, TextChatHolder.TextChatHolderEvent>(view) {

    private val binding = ItemChatTextBinding.bind(view)

    override fun onBind(item: Chat.Text, event: TextChatHolderEvent) = with(binding) {
        textView.text = item.text
        textView.setOnClickListener {
            event.onClickText(item)
        }
    }

    companion object {
        const val ID = R.layout.item_chat_text

        val DIFF = object : DiffUtil.ItemCallback<Chat.Text>() {
            override fun areItemsTheSame(oldItem: Chat.Text, newItem: Chat.Text): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Chat.Text, newItem: Chat.Text): Boolean {
                return oldItem == newItem
            }
        }

        fun from(parent: ViewGroup): ImageChatHolder {
            return ImageChatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_text, parent, false))
        }
    }

    interface TextChatHolderEvent: HolderEvent {
        fun onClickText(item: Chat.Text)
    }
}