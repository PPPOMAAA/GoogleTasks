package com.example.googletasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subtask_table")
data class GSubTask(
    @PrimaryKey(autoGenerate = true)
    val subtask_id: Int,
    val task_id: Int,
    val subtask_title: String,
)