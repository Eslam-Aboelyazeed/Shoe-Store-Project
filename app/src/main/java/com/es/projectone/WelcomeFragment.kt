package com.es.projectone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.es.projectone.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )
        binding.toInstructions.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}