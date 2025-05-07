package com.nourelden515.bostalocator.di

import com.nourelden515.bostalocator.data.source.remote.network.LocatorApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideLocatorApiService(retrofit: Retrofit): LocatorApiService {
        return retrofit.create(LocatorApiService::class.java)
    }
}