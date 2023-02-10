package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding


class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.floatingActionButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

//        for (i in 1..5) {
//            val temporaryShoeObject = Shoe(
//                shoeName = "Shoe name $i",
//                shoeCompany = "Company $i",
//                shoeSize = "$i",
//                shoeDescription = "Tennis shoe"
//            )
//            val itemShoeBinding =
//                ItemShoeBinding.inflate(layoutInflater, binding.shoeElementList, false)
//            itemShoeBinding.shoe = temporaryShoeObject
//            binding.shoeElementList.addView(itemShoeBinding.root)
//        }

        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        observeShoeList()
        setupFloatingActionButton()
        return binding.root
    }

    private fun setupFloatingActionButton() =
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

    private fun observeShoeList() =
        viewModel.shoeListViewData.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach {
                DataBindingUtil.inflate<ItemShoeBinding>(
                    layoutInflater,
                    R.layout.item_shoe,
                    binding.shoeElementList,
                    true
                ).apply {
                    this.shoe = it
                }
            }
        })

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}