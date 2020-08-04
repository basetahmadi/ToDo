package com.example.todoapp.ui.newtodo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.data.local.TodoDatabase
import com.example.todoapp.databinding.NewToDoFragmentBinding

class NewToDoFragment : Fragment() {

    private val viewModel by viewModels<NewToDoViewModel>{
        NewToDoViewModelFactory(TodoDatabase.getInstance(requireContext()).todoDao)
    }
    private lateinit var binding:NewToDoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = NewToDoFragmentBinding.inflate(inflater,container,false)
      return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewmodel=viewModel
        binding.lifecycleOwner =viewLifecycleOwner
        setupNavigation()
    }
    private fun setupNavigation() {
        viewModel.navigateToHomeEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                findNavController().navigateUp()
            }
        })
    }
}