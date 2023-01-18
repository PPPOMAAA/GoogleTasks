package com.example.googletasks.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.googletasks.data.GList
import com.example.googletasks.database.TaskDatabase
import com.example.googletasks.repositories.ListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {
    val getLists : LiveData<List<GList>>
    private val repository : ListRepository

    init {
        val listsDao = TaskDatabase.getDatabase(application).listDao()
        repository = ListRepository(listsDao)
        getLists = repository.getLists
    }

    fun addList(list: GList){
        viewModelScope.launch(Dispatchers.IO){
            repository.addList(list)
        }
    }

    fun updateList(list: GList){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateList(list)
        }
    }

    fun deleteList(list: GList){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteList(list)
        }
    }
}