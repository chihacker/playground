package io.github.chihacker.android.chatappsample.ui.friend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.chihacker.android.chatappsample.ui.friend.model.Chat

class ChatViewModel: ViewModel() {

    private val _chats: MutableLiveData<List<Chat>> = MutableLiveData(mutableListOf())
    val chats: LiveData<List<Chat>> = _chats

    fun onClickText(item: Chat.Text) {

    }
    
    fun init() {
        val list = listOf<Chat>(
            Chat.Text(id = "1", text = "hi"),
            Chat.Text(id = "2", text = "hi"),
            Chat.Text(id = "3", text = "hi")
        )

        _chats.value = list
    }

    fun fetch() {

        val list = listOf<Chat>(
            Chat.Text(id = "4", text = "hi"),
            Chat.Text(id = "5", text = "hi"),
            Chat.Text(id = "6", text = "hi")
        )

        val old = _chats.value ?: listOf()
        val newItem = old.toMutableList().apply { addAll(list) }

        _chats.value = newItem.toList()
    }

    fun changeItemToHello(id: String) {
        val item = _chats.value!!.find { it.id == id } as Chat.Text

        val newItem = item.copy(text = "hello")
        val old = _chats.value ?: listOf()
        val newList = old.toMutableList()
        newList[2] = newItem

        _chats.value = newList.toList()
    }
}