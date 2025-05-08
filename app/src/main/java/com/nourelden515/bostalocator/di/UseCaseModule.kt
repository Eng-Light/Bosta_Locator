package com.nourelden515.bostalocator.di

import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import com.nourelden515.bostalocator.domain.usecase.SearchCitiesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSearchCitiesUseCase(locatorRepository: LocatorRepository): SearchCitiesUseCase {
        return SearchCitiesUseCase(locatorRepository)
    }
}