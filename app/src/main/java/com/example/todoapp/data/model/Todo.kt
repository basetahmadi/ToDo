package com.example.todoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_todo")
data class Todo (
    @PrimaryKey(autoGenerate = true) val id : Long =0,
    val title:String = "",
    val description :String="",
    val active:Boolean = true
       /* active = true : Activated
          active = false : Completed  */

)