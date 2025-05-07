package com.nourelden515.bostalocator.ui.choosedeliveryarea

import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.domain.model.District

data class ChooseDeliveryAreaUiState(
    val isLoading: Boolean = false,
    val cities: List<CityUiState> = emptyList(),
    val searchQuery: String = "",
    val error: String? = null,
    val isError: Boolean = false,
)

data class CityUiState(
    val cityId: String,
    val cityName: String,
    val cityOtherName: String,
    val cityCode: String,
    val districts: List<District>,
    val pickupAvailability: Boolean,
    val dropOffAvailability: Boolean,
    val isExpanded: Boolean = false,
)

fun City.toUiState(): CityUiState {
    return CityUiState(
        cityId = cityId,
        cityName = cityName,
        cityOtherName = cityOtherName,
        cityCode = cityCode,
        districts = districts,
        pickupAvailability = pickupAvailability,
        dropOffAvailability = dropOffAvailability
    )
}
