package com.example.googletasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_table")
data class GList(
    @PrimaryKey(autoGenerate = true)
    val list_id: Int,
    val list_title: String,
)