package com.nourelden515.bostalocator.domain.model

data class District(
    val id: String,
    val name: String,
    val otherName: String,
    val zone: Zone,
    val hasPickupAvailability: Boolean,
    val hasDropOffAvailability: Boolean,
    val coverage: String
)