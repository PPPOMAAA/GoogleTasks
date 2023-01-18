package com.example.googletasks.repositories

import androidx.lifecycle.LiveData
import com.example.googletasks.dao.GListDao
import com.example.googletasks.data.GList

class ListRepository(private val listDao : GListDao) {
    val getLists : LiveData<List<GList>> = listDao.getLists()

    suspend fun addList(list : GList){
        listDao.addList(list)
    }
}