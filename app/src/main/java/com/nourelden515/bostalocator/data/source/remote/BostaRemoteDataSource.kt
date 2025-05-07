package com.nourelden515.bostalocator.data.source.remote

import com.nourelden515.bostalocator.data.repository.datasource.RemoteDataSource
import com.nourelden515.bostalocator.data.source.remote.network.BostaApiService
import javax.inject.Inject

class BostaRemoteDataSource @Inject constructor(
    private val bostaApiService: BostaApiService,
) : RemoteDataSource {
    override suspend fun getCities(countryId: String) =
        bostaApiService.getCities(countryId)
}