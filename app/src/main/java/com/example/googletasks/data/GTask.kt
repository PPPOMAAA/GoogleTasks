package com.example.googletasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class GTask(
    @PrimaryKey(autoGenerate = true)
    val task_id: Int,
    val list_id: Int,
    val task_title: String,
    val task_description: String,
    val date: String,
    val favorite: Boolean,
)