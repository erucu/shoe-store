package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoe_list, container, false)

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            ShoeListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}