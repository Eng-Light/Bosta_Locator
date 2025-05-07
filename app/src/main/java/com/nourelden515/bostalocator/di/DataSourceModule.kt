package com.nourelden515.bostalocator.di

import com.nourelden515.bostalocator.data.repository.datasource.RemoteDataSource
import com.nourelden515.bostalocator.data.source.remote.BostaRemoteDataSource
import com.nourelden515.bostalocator.data.source.remote.network.BostaApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataSourceModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: BostaApiService): RemoteDataSource {
        return BostaRemoteDataSource(apiService)
    }

}