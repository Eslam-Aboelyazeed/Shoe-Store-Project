package com.es.projectone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.es.projectone.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions, container, false
        )
        binding.toShoeList.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(InstructionsFragmentDirections.actionInstructionsFragmentToListFragment())
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}