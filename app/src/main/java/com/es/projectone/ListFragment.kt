package com.es.projectone

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Switch
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.es.projectone.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val viewModel by activityViewModels<SharedViewModel>()
//    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        setHasOptionsMenu(true)

        viewModel.eventAdd.observe( viewLifecycleOwner, Observer { adding ->
            if (adding) {
                findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment())
                viewModel.onAddComplete()
            }
        })

        viewModel.thelist.observe(viewLifecycleOwner, Observer {  t ->

                    val sh = TextView(context)
                    sh.text = t.toString()
                    sh.textSize = 24F
                    sh.setTextColor(Color.parseColor("#FFFFFF"))
                    binding.LinearLayout.addView(sh, 0)
                    viewModel.reset()

            })

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       // return NavigationUI.onNavDestinationSelected(item, requireView().findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment()))
        //item.itemId  R.id.loginFragment
        when (item.itemId){
           R.id.loginFragment -> findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment())
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

}