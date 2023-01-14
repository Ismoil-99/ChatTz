package com.android.chattz.domain.usecase

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.ListContactsModel
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class GetListContact @Inject constructor(
    private val requestRepository: RequestRepository
) {

    fun getListContact():LiveData<ListContactsModel>{
        return requestRepository.getListContact()
    }
}