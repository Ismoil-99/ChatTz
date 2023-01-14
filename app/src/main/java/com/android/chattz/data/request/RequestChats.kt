package com.android.chattz.data.request

import com.android.chattz.domain.model.GetUser
import com.android.chattz.domain.model.GetUserAll
import com.android.chattz.domain.model.ListContactsModel
import com.android.chattz.domain.model.Status
import retrofit2.Response
import retrofit2.http.*


interface RequestChats {
    @FormUrlEncoded
    @POST("/registration")
    suspend fun signUp(@Field("name") name:String, @Field("phone") phone: String, @Field("password") password:String): Response<Status>

    @FormUrlEncoded
    @POST("/login")
    suspend fun singIn(@Field("phone") name:String,@Field("password") phone: String,): Response<GetUser>

    @POST("/getUser")
    suspend fun getUser(): Response<GetUserAll>

    @FormUrlEncoded
    @POST("/contacts/save")
    suspend fun saveContact(@Field("contacts") contacts:String): Response<Status>

    @POST("/contacts/fetch")
    suspend fun getContactsList():Response<ListContactsModel>
}