package com.nourelden515.bostalocator.ui.choosedeliveryarea

import com.nourelden515.bostalocator.R
import com.nourelden515.bostalocator.domain.model.District
import com.nourelden515.bostalocator.ui.base.BaseAdapter
import com.nourelden515.bostalocator.ui.base.BaseInteractionListener

class DistrictAdapter(
    listener: CityInteractionListener,
) : BaseAdapter<District>(listener) {
    override val layoutID = R.layout.item_district
}