package com.nourelden515.bostalocator.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("cityId")
    val cityId: String? = null,
    @SerializedName("cityName")
    val cityName: String? = null,
    @SerializedName("cityOtherName")
    val cityOtherName: String? = null,
    @SerializedName("cityCode")
    val cityCode: String? = null,
    @SerializedName("districts")
    val districts: List<DistrictDto>,
    @SerializedName("pickupAvailability")
    val pickupAvailability: Boolean? = null,
    @SerializedName("dropOffAvailability")
    val dropOffAvailability: Boolean? = null,
)
