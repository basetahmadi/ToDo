package com.example.todoapp.data.model

import androidx.room.Entity

@Entity(tableName = "table_todo")
data class Todo (
    val id : Long =0,
    val title:String = "",
    val description :String="",
    val active:Boolean = true
       /* active = true : Activated
          active = false : Completed  */

)