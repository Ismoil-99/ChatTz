package com.android.chattz.presentation.ui.auth.singin

import androidx.lifecycle.ViewModel
import com.android.chattz.domain.usecase.SingUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SingInViewModel @Inject constructor(private val useCase: SingUpUseCase) :ViewModel() {
}