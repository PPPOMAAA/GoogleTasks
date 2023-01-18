package com.example.googletasks.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.googletasks.data.GList

@Dao
interface GListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addList(list: GList)

    @Query("SELECT * FROM list_table ORDER BY list_id ASC")
    fun getLists(): LiveData<List<GList>>
}