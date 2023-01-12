package com.android.chattz.domain.usecase

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.GetUser
import com.android.chattz.domain.repository.RequestRepository
import javax.inject.Inject

class SingInUseCase @Inject constructor(private val requestRepository: RequestRepository) {
    fun singIn(phone: String,password:String): LiveData<GetUser> {
        return requestRepository.signInUser(phone,password)
    }
}