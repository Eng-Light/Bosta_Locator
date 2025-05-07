package com.nourelden515.bostalocator.ui.utils

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nourelden515.bostalocator.domain.model.District
import com.nourelden515.bostalocator.ui.base.BaseAdapter
import com.nourelden515.bostalocator.ui.choosedeliveryarea.CityInteractionListener
import com.nourelden515.bostalocator.ui.choosedeliveryarea.DistrictAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:districtItems", "app:listener"])
fun RecyclerView.setDistricts(districts: List<District>?, listener: CityInteractionListener?) {
    if (adapter == null && listener != null) {
        adapter = DistrictAdapter(listener)
    }

    if (districts != null && adapter is DistrictAdapter) {
        (adapter as DistrictAdapter).setItems(districts)
    }
}

@BindingAdapter("app:showIfTrue")
fun showIfTrue(view: View, condition: Boolean) {
    view.isVisible = condition
}

@BindingAdapter("app:hideIfLoading")
fun hideIfLoading(view: View, condition: Boolean) {
    view.isVisible = !condition
}

@BindingAdapter(value = ["app:showIfNoItems", "app:hideIfLoading"])
fun <T> showIfEmpty(view: View, items: List<T>, condition: Boolean) {
    view.isVisible = condition == false && items.isEmpty()
}

@BindingAdapter("app:showIfNotEmpty")
fun <T> showIfNotEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}

@BindingAdapter("showIfError")
fun View.showIfError(isError: Boolean) {
    visibility = if (isError) View.VISIBLE else View.GONE
}

@BindingAdapter("errorMessage")
fun View.showErrorToast(errorMessage: String?) {
    errorMessage?.let {
        if (it.isNotEmpty()) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }
}