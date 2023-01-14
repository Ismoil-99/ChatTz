package com.android.chattz.data.repositoryimpl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.chattz.data.request.RequestChats
import com.android.chattz.domain.model.*
import com.android.chattz.domain.repository.RequestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class RequestRepositoryImpl @Inject constructor(private val requestChats: RequestChats) : RequestRepository {
    override fun signUpUser(user: User):LiveData<Status> {
            val data = MutableLiveData<Status>()
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = requestChats.signUp(user.name,user.phone,user.password)
                    if (response.isSuccessful) {
                        if (response.body() != null && response.code() == 200) {
                            data.postValue(response.body())
                        } else {
                            data.postValue(response.body())
                        }
                    } else {
                        data.postValue(response.body())
                    }
                } catch (e: HttpException) {
                    Log.d("error1", e.message.toString())
                } catch (e: Throwable) {
                    Log.d("error2", e.message.toString())
                }
            }
            return data
    }

    override fun signInUser(phone: String, pasword: String): LiveData<GetUser> {
        val data = MutableLiveData<GetUser>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = requestChats.singIn(phone,pasword)
                if (response.isSuccessful) {
                    if (response.body() != null && response.code() == 200) {
                        data.postValue(response.body())
                    } else {
                        data.postValue(response.body())
                    }
                } else {
                    data.postValue(response.body())
                }
            } catch (e: HttpException) {
                Log.d("error1", e.message.toString())
            } catch (e: Throwable) {
                Log.d("error2", e.message.toString())
            }
        }
        return data
    }

    override fun getUserAll(): LiveData<GetUserAll> {
        val data = MutableLiveData<GetUserAll>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = requestChats.getUser()
                if (response.isSuccessful) {
                    if (response.body() != null && response.code() == 200) {
                        data.postValue(response.body())
                    } else {
                        data.postValue(response.body())
                    }
                } else {
                    data.postValue(response.body())
                }
            } catch (e: HttpException) {
                Log.d("error1", e.message.toString())
            } catch (e: Throwable) {
                Log.d("error2", e.message.toString())
            }
        }
        return data
    }

    override fun saveContact(contact: String): LiveData<Status> {
        val data = MutableLiveData<Status>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = requestChats.saveContact(contact)
                if (response.isSuccessful) {
                    if (response.body() != null && response.code() == 200) {
                        data.postValue(response.body())
                    } else {
                        data.postValue(response.body())
                    }
                } else {
                    data.postValue(response.body())
                }
            } catch (e: HttpException) {
                Log.d("error1", e.message.toString())
            } catch (e: Throwable) {
                Log.d("error2", e.message.toString())
            }
        }
        return data
    }

    override fun getListContact(): LiveData<ListContactsModel> {
        val data = MutableLiveData<ListContactsModel>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = requestChats.getContactsList()
                if (response.isSuccessful) {
                    if (response.body() != null && response.code() == 200) {
                        data.postValue(response.body())
                    } else {
                        data.postValue(response.body())
                    }
                } else {
                    data.postValue(response.body())
                }
            } catch (e: HttpException) {
                Log.d("error1", e.message.toString())
            } catch (e: Throwable) {
                Log.d("error2", e.message.toString())
            }
        }
        return data
    }
}