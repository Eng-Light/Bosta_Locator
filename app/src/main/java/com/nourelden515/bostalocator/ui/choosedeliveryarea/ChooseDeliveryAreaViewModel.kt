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
                val cities = locatorRepository.getCities(DEFAULT_COUNTRY_ID)
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
            currentState.copy(
                cities = currentState.cities.map { city ->
                    city.copy(isExpanded = city.cityId == cityId && !city.isExpanded)
                }
            )
        }
    }

    override fun onCityClick(cityId: String) {
        toggleCityExpansion(cityId)
    }

    companion object {
        private const val DEFAULT_COUNTRY_ID = "60e4482c7cb7d4bc4849c4d5"
    }
}