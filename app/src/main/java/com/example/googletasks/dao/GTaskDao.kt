package com.example.googletasks.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.googletasks.data.GTask

@Dao
interface GTaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: GTask)

    @Query("SELECT * FROM task_table JOIN list_table ON list_table.list_id = :id AND list_table.list_id = task_table.list_id")
    fun getTasks(id: Int): LiveData<List<GTask>>
}