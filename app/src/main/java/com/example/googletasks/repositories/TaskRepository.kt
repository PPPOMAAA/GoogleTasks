package com.example.googletasks.repositories

import androidx.lifecycle.LiveData
import com.example.googletasks.dao.GTaskDao
import com.example.googletasks.data.GTask

class TaskRepository (private val taskDao : GTaskDao) {
    fun getTasks(id: Int) : LiveData<List<GTask>> {
        return taskDao.getTasks(id)
    }

    suspend fun addTask(task: GTask){
        taskDao.addTask(task)
    }

    suspend fun updateTask(task: GTask){
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: GTask){
        taskDao.deleteTask(task)
    }
}