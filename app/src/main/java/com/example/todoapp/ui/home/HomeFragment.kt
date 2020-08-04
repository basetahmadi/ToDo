package com.example.todoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.app.todo.ui.home.TodoAdapter
import com.example.todoapp.R
import com.example.todoapp.data.local.TodoDatabase
import com.example.todoapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //private lateinit var homeViewModel: HomeViewModel
    private val homeViewModel by activityViewModels<HomeViewModel> {
        HomeViewModelFactory(TodoDatabase.getInstance(requireContext()).todoDao)
    }
    private lateinit var binding : FragmentHomeBinding
    private lateinit var adapter: TodoAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root

        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = TodoAdapter(homeViewModel)
        binding.todoList.adapter=adapter

        // بجای کد پایینی که کامنت شده از این یکی که خلاصه تره استفاده میکنیم
        with(binding.todoList){
            val itemDecoration = DividerItemDecoration(
                context,
                (layoutManager as LinearLayout).orientation
            )
            addItemDecoration(itemDecoration)
        }

        /*
        val itemDecoration = DividerItemDecoration(
            binding.todoList.context,
            (binding.todoList.layoutManager as LinearLayout).orientation
            )
        binding.todoList.addItemDecoration(itemDecoration)
        */
    }


}