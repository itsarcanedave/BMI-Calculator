package com.example.weightdiary_lifeinformationsystem

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeightHistory::class], version = 1, exportSchema = false)
abstract class BMIDatabase : RoomDatabase() {
    abstract val DatabaseDao: DatabaseDao
    companion object Provider {
        @Volatile
        private var INSTANCE: BMIDatabase? = null
        fun getInstance(context: Context): BMIDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BMIDatabase::class.java,
                        "weight_database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}