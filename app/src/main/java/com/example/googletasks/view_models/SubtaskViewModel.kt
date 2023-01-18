package com.example.googletasks.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.googletasks.data.GSubTask
import com.example.googletasks.database.TaskDatabase
import com.example.googletasks.repositories.SubtaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubtaskViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var getSubtasks: LiveData<List<GSubTask>>
    private val repository: SubtaskRepository

    init {
        val subtaskDao = TaskDatabase.getDatabase(application).subtaskDao()
        repository = SubtaskRepository(subtaskDao)
    }

    fun addSubtask(subtask: GSubTask) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addSubtask(subtask)
        }
    }
}