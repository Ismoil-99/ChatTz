package com.android.chattz.presentation.ui.auth.singin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.chattz.domain.model.GetUser
import com.android.chattz.domain.usecase.SingInUseCase
import com.android.chattz.domain.usecase.SingUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SingInViewModel @Inject constructor(private val singInUseCase: SingInUseCase) :ViewModel() {
    fun singInUser(phone:String,password:String) :LiveData<GetUser> = singInUseCase.singIn(phone,password)
}