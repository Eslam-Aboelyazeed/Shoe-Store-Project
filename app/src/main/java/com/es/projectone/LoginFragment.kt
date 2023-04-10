package com.es.projectone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.es.projectone.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

            binding.login.setOnClickListener { view: View ->
                if (binding.username.text.toString() == "User Name" && binding.password.text.toString() == "1234" ) {
                Navigation.findNavController(view)
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }else {
                Toast.makeText(this.activity, "Please Enter User Name In Email or Username And 1234 In Password", Toast.LENGTH_LONG).show()
                    }}
        binding.signUp.setOnClickListener { view: View ->
                if (binding.username.text.toString() == "User Name" && binding.password.text.toString() == "1234" ) {
                Navigation.findNavController(view)
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }else {
                Toast.makeText(this.activity, "Please Enter User Name In Email or Username And 1234 In Password", Toast.LENGTH_LONG).show()
                    }}


        // Inflate the layout for this fragment
        return binding.root
    }

}