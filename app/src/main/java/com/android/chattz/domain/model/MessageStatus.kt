package com.android.chattz.domain.model

import com.google.gson.annotations.SerializedName

data class MessageStatus(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message:String,
    @SerializedName("messageObj")
    val messageObj:MessageObj
)

