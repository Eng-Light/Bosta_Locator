package com.nourelden515.bostalocator.di

import com.nourelden515.bostalocator.data.repository.LocatorRepositoryImpl
import com.nourelden515.bostalocator.data.source.remote.network.LocatorApiService
import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCityRepository(cityApiService: LocatorApiService): LocatorRepository {
        return LocatorRepositoryImpl(cityApiService)
    }
}