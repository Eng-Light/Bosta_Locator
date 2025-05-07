package com.nourelden515.bostalocator.domain.usecase

import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.domain.repository.LocatorRepository
import javax.inject.Inject

class SearchCitiesUseCase @Inject constructor(
    private val repository: LocatorRepository
) {

    suspend fun invoke(searchQuery: String, countryId: String): List<City> {
        val cities = repository.getCities(countryId)
        return if (searchQuery.isBlank()) {
            cities
        } else {
            val lowercaseQuery = searchQuery.lowercase().trim()
            cities.filter { city ->
                city.cityName.lowercase().contains(lowercaseQuery) ||
                        city.cityOtherName.lowercase().contains(lowercaseQuery) ||
                        city.districts.any { district ->
                            district.name.lowercase().contains(lowercaseQuery)
                        }
            }
        }
    }
}