package com.nourelden515.bostalocator.ui.choosedeliveryarea

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nourelden515.bostalocator.domain.usecase.SearchCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChooseDeliveryAreaViewModel @Inject constructor(
    private val searchCitiesUseCase: SearchCitiesUseCase,
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
                val cities = searchCitiesUseCase.invoke(state.value.searchQuery, DEFAULT_COUNTRY_ID)
                _state.update {
                    it.copy(isLoading = false, cities = cities.map { city -> city.toUiState() })
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(isLoading = false, error = e.message, isError = true)
                }
            }
        }
    }

    fun onSearchQueryChanged(query: CharSequence) {
        val searchQuery = query.toString()

        _state.update { currentState ->
            currentState.copy(
                searchQuery = searchQuery,
            )
        }
        getAllCities()
    }

    private fun toggleCityExpansion(cityId: String) {
        _state.update { currentState ->
            currentState.copy(
                cities = currentState.cities.map { city ->
                    if (city.cityId == cityId) {
                        city.copy(isExpanded = !city.isExpanded)
                    } else {
                        city.copy(isExpanded = false)
                    }
                }
            )
        }
    }

    override fun onCityClick(cityId: String) {
        toggleCityExpansion(cityId)
    }

    override fun onDistrictClick(districtId: String) {
        println(districtId)
    }

    companion object {
        private const val DEFAULT_COUNTRY_ID = "60e4482c7cb7d4bc4849c4d5"
    }
}