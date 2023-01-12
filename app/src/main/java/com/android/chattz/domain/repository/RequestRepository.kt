package com.android.chattz.domain.repository

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.model.User

interface RequestRepository {
    fun signUpUser(user: User):LiveData<Status>
}