package com.nourelden515.bostalocator.data.repository.datasource

import com.nourelden515.bostalocator.data.source.remote.model.BaseDto
import com.nourelden515.bostalocator.data.source.remote.model.CityDto
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getAllDistricts(
        countryId: String
    ): Response<BaseDto<List<CityDto>>>
}