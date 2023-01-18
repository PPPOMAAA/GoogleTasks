package com.example.googletasks.repositories

import androidx.lifecycle.LiveData
import com.example.googletasks.dao.GSubTaskDao
import com.example.googletasks.data.GSubTask

class SubtaskRepository (private val subtaskDao : GSubTaskDao) {
    fun getSubtasks(id : Int) : LiveData<List<GSubTask>> {
        return subtaskDao.getSubtasks(id)
    }

    suspend fun addSubtask(subtask: GSubTask) {
        subtaskDao.addSubtask(subtask)
    }
}