package com.nourelden515.bostalocator.data.source.remote.network

import com.nourelden515.bostalocator.data.source.remote.model.BaseDto
import com.nourelden515.bostalocator.data.source.remote.model.CityDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocatorApiService {
    @GET("cities/getAllDistricts")
    suspend fun getAllDistricts(@Query("countryId") countryId: String):
            Response<BaseDto<List<CityDto>>>
}