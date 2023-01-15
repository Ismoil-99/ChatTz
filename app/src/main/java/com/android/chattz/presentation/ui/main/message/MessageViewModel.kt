package com.android.chattz.presentation.ui.main.message

import androidx.lifecycle.ViewModel
import com.android.chattz.domain.model.SendMessageModel
import com.android.chattz.domain.usecase.GetDataSmsUseCase
import com.android.chattz.domain.usecase.SendSmSUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val sendSmSUseCase: SendSmSUseCase,
    private val getDataSmsUseCase: GetDataSmsUseCase
    ) :ViewModel() {
    fun sendSmS(sendMessageModel: SendMessageModel) = sendSmSUseCase.sendSms(sendMessageModel)

    fun getDataSms(phone: String) = getDataSmsUseCase.getDataSms(phone)
}