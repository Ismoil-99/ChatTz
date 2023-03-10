package com.android.chattz.domain.model

import com.google.gson.annotations.SerializedName

data class FetchSmsModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data:List<MessageObj>
)