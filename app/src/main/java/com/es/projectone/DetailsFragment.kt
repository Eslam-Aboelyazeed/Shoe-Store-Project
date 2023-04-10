package com.es.projectone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.es.projectone.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private val viewModel by activityViewModels<SharedViewModel>()
    private var shoe:Shoe = Shoe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )

        binding.viewModel = viewModel
        binding.shoe = shoe
        binding.setLifecycleOwner(this)

        viewModel.eventCancel.observe(viewLifecycleOwner, Observer { canceling ->
            if (canceling) {
                view?.findNavController()?.navigate(DetailsFragmentDirections.actionDetailsFragmentToListFragment())
                viewModel.onCancelComplete()
            }
        })
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { addingshoe ->
            if (addingshoe != "") {
                Log.i("DetailsFragment", "this happened")
                view?.findNavController()?.navigate(DetailsFragmentDirections.actionDetailsFragmentToListFragment())
            }
        })
        // Inflate the layout for this fragment
        return binding.root
    }



}