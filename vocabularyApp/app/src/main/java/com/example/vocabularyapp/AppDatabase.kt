package com.example.vocabularyapp

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Word::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun wordDao(): WordDao
    companion object{
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context) : AppDatabase?{
            if (INSTANCE == null){
                synchronized(AppDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database.dp"
                    ).build()
                }
            }
            return INSTANCE
        }

    }
}