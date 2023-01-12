package com.android.chattz.data.request

import com.android.chattz.domain.model.Status
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RequestChats {

    @FormUrlEncoded
    @POST("/registration")
    suspend fun signUp(
        @Field("name") name:String,
        @Field("phone") phone: String,
        @Field("password") password:String
    ): Response<Status>
}