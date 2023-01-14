package com.android.chattz.presentation.ui.main.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.chattz.domain.model.GetUserAll
import com.android.chattz.domain.model.ListContactsModel
import com.android.chattz.domain.model.Status
import com.android.chattz.domain.usecase.GetContact
import com.android.chattz.domain.usecase.GetListContact
import com.android.chattz.domain.usecase.GetUserAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getUserAllUseCase: GetUserAllUseCase,
    private val getListContact: GetListContact

    ) :ViewModel() {
    fun getUser() : LiveData<GetUserAll> = getUserAllUseCase.getUser()
    fun getListContacts():LiveData<ListContactsModel> = getListContact.getListContact()
}