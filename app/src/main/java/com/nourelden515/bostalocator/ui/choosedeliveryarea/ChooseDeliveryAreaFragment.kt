package com.nourelden515.bostalocator.ui.choosedeliveryarea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nourelden515.bostalocator.BR
import com.nourelden515.bostalocator.BostaLocatorApplication
import com.nourelden515.bostalocator.R
import com.nourelden515.bostalocator.databinding.FragmentChooseDeliveryAreaBinding

class ChooseDeliveryAreaFragment : Fragment() {
    private lateinit var _binding: FragmentChooseDeliveryAreaBinding
    val binding get() = _binding

    private val viewModel: ChooseDeliveryAreaViewModel by viewModels {
        (requireActivity().application as BostaLocatorApplication).appComponent.viewModelsFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_choose_delivery_area,
            container, false
        )

        _binding.viewModel = viewModel

        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateAdapter()
    }

    private fun initiateAdapter() {
        val citiesAdapter = CityAdapter(viewModel)
        binding.citiesRecyclerView.adapter = citiesAdapter
    }
}