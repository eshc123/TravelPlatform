package com.eshc.travelplatform.di

import com.eshc.data.local.datasource.CourseLocalDataSource
import com.eshc.data.local.datasourceImpl.CourseLocalDataSourceImpl
import com.eshc.data.repository.CourseRepositoryImpl
import com.eshc.domain.repository.CourseRepository
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
}