package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.floatingActionButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(, R.layout.fragment_shoe_list)

        val myLayout: LinearLayout = findViewById(R.id.fragment_shoe_list)

        val myButton = Button(this)
        myButton.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        myLayout.addView(myButton)

    }
}