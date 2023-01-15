package com.android.chattz.domain.repository

import androidx.lifecycle.LiveData
import com.android.chattz.domain.model.*

interface RequestRepository {
    fun signUpUser(user: User):LiveData<Status>
    fun signInUser(phone:String,pasword:String):LiveData<GetUser>
    fun getUserAll():LiveData<GetUserAll>
    fun saveContact(contact:String):LiveData<Status>
    fun getListContact():LiveData<ListContactsModel>
    fun sendSms(sendMessageModel: SendMessageModel):LiveData<MessageStatus>
    fun getDataSms(phone: String):LiveData<FetchSmsModel>
}