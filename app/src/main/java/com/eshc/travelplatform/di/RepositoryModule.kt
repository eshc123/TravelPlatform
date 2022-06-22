package com.eshc.travelplatform.di

import com.eshc.data.local.datasourceImpl.CourseLocalDataSourceImpl
import com.eshc.data.local.datasourceImpl.UserLocalDataSourceImpl
import com.eshc.data.remote.datasourceImpl.SpotRemoteDataSourceImpl
import com.eshc.data.remote.datasourceImpl.UserRemoteDataSourceImpl
import com.eshc.data.repository.CourseRepositoryImpl
import com.eshc.data.repository.SpotRepositoryImpl
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.data.repository.UserRepositoryImpl
import com.eshc.domain.repository.CourseRepository
import com.eshc.domain.repository.SpotRepository
import com.eshc.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCourseRepository(
        courseLocalDataSourceImpl: CourseLocalDataSourceImpl
    ): CourseRepository {
        return CourseRepositoryImpl(
            courseLocalDataSourceImpl
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userRemoteDataSourceImpl: UserRemoteDataSourceImpl,
        userLocalDataSourceImpl: UserLocalDataSourceImpl
    ) : UserRepository{
        return UserRepositoryImpl(userRemoteDataSourceImpl,userLocalDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideSpotRepository(
        spotRemoteDataSourceImpl: SpotRemoteDataSourceImpl
    ) : SpotRepository{
        return SpotRepositoryImpl(spotRemoteDataSourceImpl)
    }
}