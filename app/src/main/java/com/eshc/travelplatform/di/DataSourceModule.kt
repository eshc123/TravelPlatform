package com.eshc.travelplatform.di

import com.eshc.data.remote.datasource.SpotRemoteDataSource
import com.eshc.data.remote.datasource.UserRemoteDataSource
import com.eshc.data.remote.datasourceImpl.SpotRemoteDataSourceImpl
import com.eshc.data.remote.datasourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideUserRemoteDataSource() : UserRemoteDataSource {
        return UserRemoteDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideSpotRemoteDataSourece() : SpotRemoteDataSource {
        return SpotRemoteDataSourceImpl()
    }
}