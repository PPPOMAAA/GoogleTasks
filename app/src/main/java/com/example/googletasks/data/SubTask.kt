package com.example.googletasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subtask_table")
data class SubTask(
    @PrimaryKey(autoGenerate = true)
    val subtask_id: Int,
    val task_id: Int,
    val subtask_title: String,
)