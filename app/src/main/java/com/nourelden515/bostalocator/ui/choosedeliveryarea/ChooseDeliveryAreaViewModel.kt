package com.nourelden515.bostalocator.ui.choosedeliveryarea

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChooseDeliveryAreaViewModel @Inject constructor(
    private val locatorRepository: LocatorRepository
) : ViewModel(), CityInteractionListener {

    private val _state = MutableStateFlow(ChooseDeliveryAreaUiState())
    val state = _state.asStateFlow()

    private val _searchQuery = MutableStateFlow("")

    init {
        getAllCities()
    }

    fun getAllCities() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, isError = false, error = null) }

            try {
                val cities = locatorRepository.getCities(DEFAULT_COUNTRY_ID)
                _state.update {
                    it.copy(
                        isLoading = false,
                        cities = cities.map { city ->
                            city.toUiState()
                        })
                }
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

    val filteredCities: StateFlow<List<CityUiState>> = combine(
        _state,
        _searchQuery
    ) { state, query ->
        if (query.isBlank()) {
            state.cities
        } else {
            val lowercaseQuery = query.lowercase().trim()
            state.cities.filter { city ->
                city.cityName.lowercase().contains(lowercaseQuery) ||
                        city.cityOtherName.lowercase().contains(lowercaseQuery) ||
                        city.districts.any { district ->
                            district.name.lowercase().contains(lowercaseQuery)
                        }
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(STOP_TIMEOUT),
        initialValue = emptyList()
    )

    fun onSearchQueryChanged(query: CharSequence) {
        _searchQuery.value = query.toString()
        _state.update { currentState ->
            currentState.copy(
                searchQuery = query.toString()
            )
        }
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
        private const val STOP_TIMEOUT = 5000L
    }
}