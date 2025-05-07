package com.nourelden515.bostalocator.data.repository

import com.nourelden515.bostalocator.data.repository.datasource.RemoteDataSource
import com.nourelden515.bostalocator.data.source.remote.mapper.toEntity
import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import javax.inject.Inject

class LocatorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : LocatorRepository {

    private var cities: List<City> = listOf()

    override suspend fun getCities(
        countryId: String
    ): List<City> {
        return cities.ifEmpty {
            wrapApiResponse {
                remoteDataSource.getCities(countryId)
            }.data.toEntity()
                .also { cities = it }
        }
    }
}