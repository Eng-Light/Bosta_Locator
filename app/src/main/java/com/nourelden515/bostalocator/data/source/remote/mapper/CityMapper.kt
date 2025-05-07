package com.nourelden515.bostalocator.data.source.remote.mapper

import com.nourelden515.bostalocator.data.source.remote.model.CityDto
import com.nourelden515.bostalocator.domain.model.City

fun List<CityDto>.toEntity(): List<City> = this.map { it.toEntity() }

fun CityDto.toEntity() = City(
    cityId = cityId ?: "",
    cityName = cityName ?: "",
    cityOtherName = cityOtherName ?: "",
    cityCode = cityCode ?: "",
    districts = districts.map {
        it.toEntity()
    },
    pickupAvailability = pickupAvailability ?: false,
    dropOffAvailability = dropOffAvailability ?: false
)