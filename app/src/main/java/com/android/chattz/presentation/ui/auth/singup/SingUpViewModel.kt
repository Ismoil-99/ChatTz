package com.android.chattz.presentation.ui.auth.singup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.model.User
import com.android.chattz.domain.usecase.SingUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SingUpViewModel @Inject constructor(private val useCase: SingUpUseCase) :ViewModel(){
     fun singUp(user: User):LiveData<Status> = useCase.singUp(user)
}