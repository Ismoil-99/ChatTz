package com.android.chattz.domain.model

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("status")
    val status:String,
    @SerializedName("message")
    val message:String
)