package com.example.todoapp.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.data.model.Todo
import kotlinx.coroutines.*

class StatisticsViewModel(private val dataSource:TodoDao) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.Main)
    init {
        scope.launch {
           val listTodo =  getAllFromDataBase()
            var counter1 = 0

         //   var counter2 = 0
          /*  listTodo.forEach(){
                if (isActive){
                    counter1++
                }else{
                    counter2++
                }
            }*/

            counter1 = listTodo.count(){
                it.active
            }

            val activated : Int = (counter1 * 100/listTodo.size)
            _counter1LiveData.value ="Activated : "+ (activated).toString() + " %"
            _counter2LiveData.value ="Completed : "+(100-activated).toString()+ " %"
        }
    }

    private val _counter1LiveData= MutableLiveData<String>()
    val counter1LiveData:LiveData<String> = _counter1LiveData

    private val _counter2LiveData=MutableLiveData<String>()
    val counter2LiveData:LiveData<String>  = _counter2LiveData


    suspend fun getAllFromDataBase() :List<Todo> = withContext(Dispatchers.IO){
        dataSource.getAll()
    }


}