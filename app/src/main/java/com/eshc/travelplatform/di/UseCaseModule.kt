package com.eshc.travelplatform.di

import com.eshc.domain.repository.UserRepository
import com.eshc.domain.usecase.user.LoginUseCase
import com.eshc.domain.usecase.user.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideLoginUseCase(repository: UserRepository) = LoginUseCase(repository)

    @Provides
    @Singleton
    fun provideRegisterUseCase(repository: UserRepository) = RegisterUseCase(repository)
}