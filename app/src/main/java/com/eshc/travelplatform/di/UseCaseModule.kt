package com.eshc.travelplatform.di

import com.eshc.domain.repository.SpotRepository
import com.eshc.domain.repository.UserRepository
import com.eshc.domain.usecase.spot.*
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

    @Provides
    @Singleton
    fun provideGetSpotUseCase(repository: SpotRepository) = GetSpotUseCase(repository)

    @Provides
    @Singleton
    fun provideGetKeepSpotsUseCase(repository: SpotRepository) = GetKeepSpotsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetPopularSpotsUseCase(repository: SpotRepository) = GetPopularSpotsUseCase(repository)

    @Provides
    @Singleton
    fun provideDeleteKeepSpotUseCase(repository: SpotRepository) = DeleteKeepSpotUseCase(repository)

    @Provides
    @Singleton
    fun providePostKeepSpotUseCase(repository: SpotRepository) = PostKeepSpotUseCase(repository)
}