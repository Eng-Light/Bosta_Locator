package com.nourelden515.bostalocator.domain.usecase

import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.domain.model.District
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
            searchCities(cities, searchQuery)
        }
    }

    private fun searchCities(cities: List<City>, query: String): List<City> {
        val normalizedQuery = normalizeQuery(query)

        return cities.mapNotNull { city ->
            filterCityByQuery(city, normalizedQuery)
        }
    }

    private fun normalizeQuery(query: String): String {
        return query.lowercase().trim()
    }

    private fun filterCityByQuery(city: City, normalizedQuery: String): City? {
        val cityMatchesQuery = doesCityMatchQuery(city, normalizedQuery)
        val matchingDistricts = findMatchingDistricts(city.districts, normalizedQuery)

        return when {
            cityMatchesQuery || matchingDistricts.isNotEmpty() -> {
                val districtsToKeep = if (cityMatchesQuery) city.districts else matchingDistricts
                city.copy(districts = districtsToKeep)
            }
            else -> null
        }
    }

    private fun doesCityMatchQuery(city: City, normalizedQuery: String): Boolean {
        return city.cityName.lowercase().contains(normalizedQuery) ||
                city.cityOtherName.lowercase().contains(normalizedQuery)
    }

    private fun findMatchingDistricts(districts: List<District>, normalizedQuery: String): List<District> {
        return districts.filter { district ->
            doesDistrictMatchQuery(district, normalizedQuery)
        }
    }

    private fun doesDistrictMatchQuery(district: District, normalizedQuery: String): Boolean {
        return district.name.lowercase().contains(normalizedQuery) ||
                district.otherName.lowercase().contains(normalizedQuery) ||
                district.zone.name.lowercase().contains(normalizedQuery) ||
                district.zone.otherName.lowercase().contains(normalizedQuery)
    }
}