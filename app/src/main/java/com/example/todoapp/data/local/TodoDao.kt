package com.example.todoapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.model.Todo

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todo: Todo) :Long

    @Update
    suspend fun update(todo: Todo)

    @Query("select * from table_todo")
    suspend fun getAll():List<Todo>

    @Query("select * from table_todo")
    fun observeAll():LiveData<List<Todo>?>
}