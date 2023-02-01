package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.data.model.Shoe
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.ui.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false)
        binding.saveButton.setOnClickListener {
            val shoe = Shoe(binding.nameField.text.toString(), binding.sizeField.text.toString().toDouble(), binding.companyField.text.toString(), binding.descriptionField.text.toString())
            viewModel.addShoe(shoe)
            val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            findNavController().navigate(action)
        }
        binding.cancelButton.setOnClickListener {
            val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

}
