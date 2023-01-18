package com.example.googletasks.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.googletasks.dao.GListDao
import com.example.googletasks.dao.GSubTaskDao
import com.example.googletasks.dao.GTaskDao
import com.example.googletasks.data.GList
import com.example.googletasks.data.GSubTask
import com.example.googletasks.data.GTask

@Database(entities = [GList::class, GTask::class, GSubTask::class], version = 10, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun listDao() : GListDao
    abstract fun taskDao() : GTaskDao
    abstract fun subtaskDao() : GSubTaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context) : TaskDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}