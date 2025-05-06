package com.nourelden515.bostalocator.ui.choosedeliveryarea

import com.nourelden515.bostalocator.domain.model.City

data class ChooseDeliveryAreaUiState(
    val isLoading: Boolean = false,
    val cities: List<City> = emptyList(),
    val error: String? = null,
    val isError: Boolean = false,
    val expandedCityId: String? = null
)
