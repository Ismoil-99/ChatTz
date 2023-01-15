package com.android.chattz.domain.usecase

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.FetchSmsModel
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class GetDataSmsUseCase @Inject constructor(private val repository: RequestRepository) {
    fun getDataSms(phone: String): LiveData<FetchSmsModel> {
        return repository.getDataSms(phone)
    }
}