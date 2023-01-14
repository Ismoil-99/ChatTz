package com.android.chattz.domain.model

import com.google.gson.annotations.SerializedName

data class ListContactsModel(
    @SerializedName("status")
    val status:String,
    @SerializedName("message")
    val message:String,
    @SerializedName("contacts")
    val contacts: ArrayList<User>
)

