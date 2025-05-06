package com.nourelden515.bostalocator.ui.choosedeliveryarea

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nourelden515.bostalocator.R

class ChooseDeliveryAreaFragment : Fragment() {

    companion object {
        fun newInstance() = ChooseDeliveryAreaFragment()
    }

    private val viewModel: ChooseDeliveryAreaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_choose_delivery_area, container, false)
    }
}