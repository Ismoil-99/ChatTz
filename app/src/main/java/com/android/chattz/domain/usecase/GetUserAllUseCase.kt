package com.android.chattz.domain.usecase

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.GetUserAll
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class GetUserAllUseCase @Inject constructor(private val requestRepository: RequestRepository) {
    fun getUser(): LiveData<GetUserAll> {
        return requestRepository.getUserAll()
    }
}