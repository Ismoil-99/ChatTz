package com.android.chattz.presentation.ui.main.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.usecase.GetContact
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val getContact: GetContact) :ViewModel() {
    fun getContact(contact: String): LiveData<Status> = getContact.saveContacts(contact)
}