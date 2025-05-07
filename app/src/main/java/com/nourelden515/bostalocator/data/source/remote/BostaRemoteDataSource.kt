package com.nourelden515.bostalocator.data.source.remote

import com.nourelden515.bostalocator.data.repository.datasource.RemoteDataSource
import com.nourelden515.bostalocator.data.source.remote.network.LocatorApiService
import javax.inject.Inject

class BostaRemoteDataSource @Inject constructor(
    private val locatorApiService: LocatorApiService,
) : RemoteDataSource {
    override suspend fun getAllDistricts(countryId: String) =
        locatorApiService.getAllDistricts(countryId)
}