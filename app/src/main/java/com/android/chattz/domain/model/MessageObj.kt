package com.android.chattz.domain.model

import com.google.gson.annotations.SerializedName

data class MessageObj(
    @SerializedName("_id")
    val _id:String,
    @SerializedName("message")
    val message: String,
    @SerializedName("sender")
    val sender:User,
    @SerializedName("receiver")
    val receiver:User,
    @SerializedName("createdAt")
    val createdAt:Double = 0.0,
)