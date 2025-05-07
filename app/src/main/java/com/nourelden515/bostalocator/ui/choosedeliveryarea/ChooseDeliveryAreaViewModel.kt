package com.nourelden515.bostalocator.ui.choosedeliveryarea

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChooseDeliveryAreaViewModel @Inject constructor(
    private val locatorRepository: LocatorRepository
) : ViewModel(), CityInteractionListener {

    private val _state = MutableStateFlow(ChooseDeliveryAreaUiState())
    val state = _state.asStateFlow()

    init {
        getAllCities()
    }

    fun getAllCities() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, isError = false, error = null) }
            try {
                val cities = locatorRepository.getCities("60e4482c7cb7d4bc4849c4d5")
                _state.update { it.copy(isLoading = false, cities = cities.map { it.toUiState() }) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message,
                        isError = true
                    )
                }
            }
        }
    }

    private fun toggleCityExpansion(cityId: String) {
        _state.update { currentState ->
            val updatedCities = currentState.cities.map { city ->
                if (city.cityId == cityId) {
                    city.copy(isExpanded = !city.isExpanded)
                } else {
                    city.copy(isExpanded = false)
                }
            }
            currentState.copy(cities = updatedCities)
        }
    }

    override fun onCityClick(cityId: String) {
        toggleCityExpansion(cityId)
    }
}