package io.github.chihacker.android.chatappsample.ui.friend.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import io.github.chihacker.android.chatappsample.R
import io.github.chihacker.android.chatappsample.databinding.ItemChatImageBinding
import io.github.chihacker.android.chatappsample.ui.friend.model.Chat

class ImageChatHolder(view: View): ChatHolder<Chat.Image, ImageChatHolder.ImageChatHolderEvent>(view) {

    private val binding = ItemChatImageBinding.bind(view)

    override fun onBind(item: Chat.Image, action: ImageChatHolderEvent) {
        binding.imageView.setOnClickListener {
            action.onClickImage(item)
        }
    }

    companion object {
        const val ID = R.layout.item_chat_image

        val DIFF = object : DiffUtil.ItemCallback<Chat.Image>() {
            override fun areItemsTheSame(oldItem: Chat.Image, newItem: Chat.Image): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Chat.Image, newItem: Chat.Image): Boolean {
                return oldItem == newItem
            }
        }

        fun from(parent: ViewGroup): ImageChatHolder {
            return ImageChatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_image, parent, false))
        }
    }

    interface ImageChatHolderEvent: HolderEvent {
        fun onClickImage(item: Chat.Image)
    }
}