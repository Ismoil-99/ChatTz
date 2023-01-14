package com.android.chattz.data.api

import com.android.chattz.app.App
import com.android.chattz.data.request.RequestChats
import com.android.chattz.utils.TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "http://192.168.207.67:3000/"

@Module
@InstallIn(SingletonComponent::class)
object ApiChat {

    private var client = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${App.sharedPreferences.getString(TOKEN,"")}")
            .build()
        chain.proceed(newRequest)
    }.build()

    private val retrofitClient: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getRetrofitRequest() : RequestChats = retrofitClient.create(RequestChats::class.java)
}