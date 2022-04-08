package com.android.navegacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.android.navegacion.databinding.FragmentNameBinding


class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding

    //Para uso compartido del ViewModel activityViewModels()
    private val viewModel: MainViewModel by  activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.actionNext.setOnClickListener{
            val navContrller = findNavController()
            navContrller.navigate(R.id.action_nameFragment_to_lastNameFragment)
        }
    }

}