package com.example.googletasks.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.googletasks.data.GList

@Dao
interface GListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addList(list: GList)

    @Update
    suspend fun updateList(list : GList)

    @Delete
    suspend fun  deleteList(list : GList)

    @Query("SELECT * FROM list_table ORDER BY list_id ASC")
    fun getLists(): LiveData<List<GList>>
}