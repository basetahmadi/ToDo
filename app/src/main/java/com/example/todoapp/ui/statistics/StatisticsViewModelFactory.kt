package com.example.todoapp.ui.statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.todoapp.data.local.TodoDao

class StatisticsViewModelFactory(private val dataSource: TodoDao): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StatisticsViewModel(dataSource) as T
    }
}