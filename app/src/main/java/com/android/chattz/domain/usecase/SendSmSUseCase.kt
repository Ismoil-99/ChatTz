package com.android.chattz.domain.usecase

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.MessageObj
import com.android.chattz.domain.model.MessageStatus
import com.android.chattz.domain.model.SendMessageModel
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class SendSmSUseCase @Inject constructor(private val repository: RequestRepository) {
    fun sendSms(sendMessageModel: SendMessageModel): LiveData<MessageStatus> {
        return repository.sendSms(sendMessageModel)
    }
}