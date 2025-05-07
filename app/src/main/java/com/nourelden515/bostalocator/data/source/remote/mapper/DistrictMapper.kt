package com.nourelden515.bostalocator.data.source.remote.mapper

import com.nourelden515.bostalocator.data.source.remote.model.DistrictDto
import com.nourelden515.bostalocator.domain.model.District
import com.nourelden515.bostalocator.domain.model.Zone

fun DistrictDto.toEntity() = District(
    id = districtId ?: "",
    name = districtName ?: "",
    otherName = districtOtherName ?: "",
    zone = Zone(
        id = zoneId ?: "",
        name = zoneName ?: "",
        otherName = zoneOtherName ?: "",
    ),
    hasPickupAvailability = pickupAvailability ?: false,
    hasDropOffAvailability = dropOffAvailability ?: false,
    coverage = coverage ?: "",
)