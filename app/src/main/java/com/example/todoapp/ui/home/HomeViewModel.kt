package com.example.todoapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.local.TodoDao

class HomeViewModel(dataSource:TodoDao): ViewModel() {

    val todos = dataSource.observeAll()

}