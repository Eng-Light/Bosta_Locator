package com.nourelden515.bostalocator.data.repository

import com.nourelden515.bostalocator.data.repository.datasource.RemoteDataSource
import com.nourelden515.bostalocator.data.source.remote.mapper.toEntity
import com.nourelden515.bostalocator.data.source.remote.network.LocatorApiService
import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.domain.repository.LocatorRepository

class LocatorRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : LocatorRepository {

    override suspend fun getCities(
        countryId: String
    ): List<City> = wrapApiResponse {
        remoteDataSource.getAllDistricts(countryId)
    }.data.toEntity()
}