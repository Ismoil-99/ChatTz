package com.android.chattz.di

import com.android.chattz.data.repositoryimpl.RequestRepositoryImpl
import com.android.chattz.domain.repository.RequestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsRepository(repoImpl:RequestRepositoryImpl):RequestRepository
}