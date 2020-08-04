package com.example.todoapp.ui.newtodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.data.model.Todo
import com.separ.Event
import kotlinx.coroutines.*

class NewToDoViewModel(private val dataSource:TodoDao) : ViewModel() {

    private val job = Job()

    private val scope = CoroutineScope(Dispatchers.Main+job)

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    private val _navigateToHomeEvent = MutableLiveData<Event<Any>>()
    val navigateToHomeEvent : LiveData<Event<Any>> = _navigateToHomeEvent

    fun addTodo(){
        val titleText = title.value ?:"Title Test"
        val descText = description.value ?:"Description Test"
        scope.launch {
            insertIntoDatabse(Todo(title = titleText,description = descText))
            _navigateToHomeEvent.postValue(Event(Any()))
        }
    }
    private suspend fun insertIntoDatabse(todo:Todo)= withContext(Dispatchers.IO){
        dataSource.insert(todo)
    }

}