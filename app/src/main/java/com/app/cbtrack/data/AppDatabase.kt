package com.app.cbtrack.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database(entities = [Feelings::class], version = 1)
@TypeConverters(DateTypeConverter::class, FeelingTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun feelingsDao() : FeelingsDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "App_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}