package com.example.googletasks.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.googletasks.data.GTask
import com.example.googletasks.database.TaskDatabase
import com.example.googletasks.repositories.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var getTasks: LiveData<List<GTask>>
    private val repository : TaskRepository

    init{
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
    }

    fun addTask(task: GTask){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }

    fun updateTask(task: GTask){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: GTask){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTask(task)
        }
    }
}