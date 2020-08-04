package com.example.todoapp.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.todo.ui.home.TodoAdapter
import com.example.todoapp.data.model.Todo

@BindingAdapter("todoItems")
fun RecyclerView.todoItems(items:List<Todo>?){
    items?.let {
        (adapter as TodoAdapter).submitList(items)
    }
}