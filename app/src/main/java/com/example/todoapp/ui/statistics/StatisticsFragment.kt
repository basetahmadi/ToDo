package com.example.todoapp.ui.statistics

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.data.local.TodoDatabase
import com.example.todoapp.databinding.StatisticsFragmentBinding

class StatisticsFragment : Fragment() {

    private val viewModel by viewModels<StatisticsViewModel>(){
        StatisticsViewModelFactory(TodoDatabase.getInstance(requireContext()).todoDao)
    }
    private lateinit var binding: StatisticsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StatisticsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }

}