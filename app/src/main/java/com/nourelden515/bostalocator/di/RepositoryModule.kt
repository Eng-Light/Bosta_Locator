package com.nourelden515.bostalocator.di

import com.nourelden515.bostalocator.data.repository.LocatorRepositoryImpl
import com.nourelden515.bostalocator.data.repository.datasource.RemoteDataSource
import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCityRepository(dataSource: RemoteDataSource): LocatorRepository {
        return LocatorRepositoryImpl(dataSource)
    }
}