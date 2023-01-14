package com.android.chattz.domain.usecase


import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class GetContact @Inject constructor(private val requestRepository: RequestRepository)  {
    fun saveContacts(contacts: String):LiveData<Status>{
        return requestRepository.saveContact(contacts)
    }
}