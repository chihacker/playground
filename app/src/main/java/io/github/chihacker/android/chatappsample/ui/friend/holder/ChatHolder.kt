package io.github.chihacker.android.chatappsample.ui.friend.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.chihacker.android.chatappsample.ui.friend.model.Chat

abstract class ChatHolder<T: Chat, A: HolderEvent>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun onBind(item: T, event: A)
}

interface HolderEvent