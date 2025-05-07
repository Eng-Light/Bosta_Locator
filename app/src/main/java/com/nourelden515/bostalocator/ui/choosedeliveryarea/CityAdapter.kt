package com.nourelden515.bostalocator.ui.choosedeliveryarea

import com.nourelden515.bostalocator.R
import com.nourelden515.bostalocator.domain.model.City
import com.nourelden515.bostalocator.ui.base.BaseAdapter
import com.nourelden515.bostalocator.ui.base.BaseInteractionListener

class CityAdapter(
    listener: CityInteractionListener
) : BaseAdapter<City>(listener) {
    override val layoutID = R.layout.item_city
}

interface CityInteractionListener : BaseInteractionListener {
    fun onCityClick(cityId: String)
}
