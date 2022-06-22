package com.eshc.travelplatform.di

import android.content.Context
import com.eshc.data.local.datasource.UserLocalDataSource
import com.eshc.data.local.datasourceImpl.UserLocalDataSourceImpl
import com.eshc.data.remote.datasource.SpotRemoteDataSource
import com.eshc.data.remote.datasource.UserRemoteDataSource
import com.eshc.data.remote.datasourceImpl.SpotRemoteDataSourceImpl
import com.eshc.data.remote.datasourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideUserLocalDataSource(@ApplicationContext context: Context) : UserLocalDataSource {
        return UserLocalDataSourceImpl(context)
    }

    @Provides
    @Singleton
    fun provideSpotRemoteDataSourece() : SpotRemoteDataSource {
        return SpotRemoteDataSourceImpl()
    }


}