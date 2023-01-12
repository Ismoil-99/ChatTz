package com.android.chattz.data.api

import com.android.chattz.data.request.RequestChats
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "http://192.168.78.171:3000/"

@Module
@InstallIn(SingletonComponent::class)
object ApiChat {
    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getRetrofitRequest() : RequestChats = retrofitClient.create(RequestChats::class.java)
}