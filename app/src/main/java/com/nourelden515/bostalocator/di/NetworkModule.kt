package com.nourelden515.bostalocator.di

import com.nourelden515.bostalocator.data.source.remote.network.BostaApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideLocatorApiService(retrofit: Retrofit): BostaApiService {
        return retrofit.create(BostaApiService::class.java)
    }
}