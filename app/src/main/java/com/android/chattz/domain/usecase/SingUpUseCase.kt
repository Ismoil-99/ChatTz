package com.android.chattz.domain.usecase

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.model.User
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class SingUpUseCase @Inject constructor(private val requestRepository: RequestRepository) {
    fun singUp(user: User):LiveData<Status>{
        return requestRepository.signUpUser(user)
    }
}