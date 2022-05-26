package com.eshc.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.eshc.data.local.db.dao.*
import com.eshc.data.local.db.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [CourseEntity::class, DailyScheduleEntity::class,KeepEntity::class,ScheduleEntity::class,
    SpotEntity::class,UserEntity::class,LocationCategoryEntity::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scheduleDao() : ScheduleDao
    abstract fun courseDao() : CourseDao
    abstract fun dailyScheduleDao() : DailyScheduleDao
    abstract fun keepDao() : KeepDao
    abstract fun spotDao() : SpotDao
    abstract fun userDao() : UserDao
    abstract fun locationCategoryDao() : LocationCategoryDao

    private class AppDatabaseCallBack(
        private val scope : CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    database.spotDao().insertSpots(DataGenerator.getSpots())
                }
            }
        }
    }
    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context, applicationScope: CoroutineScope) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(AppDatabaseCallBack(scope = applicationScope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}