package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)
        binding.buttonCancel.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.buttonSave.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }
}