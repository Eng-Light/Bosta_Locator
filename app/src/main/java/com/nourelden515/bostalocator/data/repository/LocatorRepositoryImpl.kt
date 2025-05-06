package com.nourelden515.bostalocator.data.repository

import com.nourelden515.bostalocator.data.source.remote.mapper.toEntity
import com.nourelden515.bostalocator.data.source.remote.network.LocatorApiService
import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.domain.repository.LocatorRepository

class LocatorRepositoryImpl(
    private val locatorApiService: LocatorApiService,
) : LocatorRepository {

    override suspend fun getCities(
        countryId: String
    ): List<City> = wrapApiResponse {
        locatorApiService.getAllDistricts(countryId)
    }.data.toEntity()
}