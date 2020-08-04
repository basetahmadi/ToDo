package com.example.todoapp.ui.newtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.ui.home.HomeViewModel

class NewToDoViewModelFactory(private val dataSource: TodoDao) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewToDoViewModel(dataSource) as T
    }
}