package com.example.googletasks.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.googletasks.data.GSubTask

@Dao
interface GSubTaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubtask(subtask: GSubTask)

    @Update
    suspend fun updateSubtask(subtask: GSubTask)

    @Delete
    suspend fun deleteSubtask(subtask: GSubTask)

    @Query("SELECT * FROM subtask_table JOIN task_table ON task_table.task_id = :id AND task_table.task_id = subtask_table.task_id")
    fun getSubtasks(id: Int): LiveData<List<GSubTask>>
}