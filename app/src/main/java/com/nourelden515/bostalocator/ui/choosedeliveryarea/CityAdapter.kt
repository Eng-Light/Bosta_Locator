package com.nourelden515.bostalocator.ui.choosedeliveryarea

import com.nourelden515.bostalocator.R
import com.nourelden515.bostalocator.ui.base.BaseAdapter
import com.nourelden515.bostalocator.ui.base.BaseInteractionListener

class CityAdapter(
    listener: CityInteractionListener
) : BaseAdapter<CityUiState>(listener) {
    override val layoutID = R.layout.item_city

    override fun areItemsSame(oldItem: CityUiState, newItem: CityUiState): Boolean {
        return oldItem.cityId == newItem.cityId
    }

    override fun areContentSame(oldItem: CityUiState, newItem: CityUiState): Boolean {
        return oldItem.isExpanded == newItem.isExpanded &&
                oldItem.cityName == newItem.cityName &&
                oldItem.districts == newItem.districts
    }
}

interface CityInteractionListener : BaseInteractionListener {
    fun onCityClick(cityId: String)
    fun onDistrictClick(districtId: String)
}