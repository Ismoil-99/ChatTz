package com.android.chattz.domain.model

import com.google.gson.annotations.SerializedName

data class GetUser(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message:String,
    @SerializedName("accessToken")
    val accessToken:String,
    val user:GetUserInfo
)
data class GetUserInfo(
    @SerializedName("_id")
    val _id:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("phone")
    val phone:String
)
