package com.nourelden515.bostalocator.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class DistrictDto(
    @SerializedName("zoneId")
    val zoneId: String? = null,
    @SerializedName("zoneName")
    val zoneName: String? = null,
    @SerializedName("zoneOtherName")
    val zoneOtherName: String? = null,
    @SerializedName("districtId")
    val districtId: String? = null,
    @SerializedName("districtName")
    val districtName: String? = null,
    @SerializedName("districtOtherName")
    val districtOtherName: String? = null,
    @SerializedName("pickupAvailability")
    val pickupAvailability: Boolean? = null,
    @SerializedName("dropOffAvailability")
    val dropOffAvailability: Boolean? = null,
    @SerializedName("coverage")
    val coverage: String? = null,
)