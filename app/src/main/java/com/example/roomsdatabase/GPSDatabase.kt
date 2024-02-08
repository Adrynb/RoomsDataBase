package com.example.roomsdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomsdatabase.Coords.CoordinateDao
import com.example.roomsdatabase.Routes.Route
import com.example.roomsdatabase.Routes.RouteDao

@Database(
    entities = [Route::class],
    version = 6,
    exportSchema = true
)
@TypeConverters(Converters::class)


abstract class GPSDatabase : RoomDatabase() {

    abstract fun routeDao() : RouteDao
    abstract fun coordDao() : CoordinateDao


    companion object{

        private var instance : GPSDatabase ? = null

        @Synchronized
        fun getInstance(ctx : Context) : GPSDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, GPSDatabase::class.java,
                    "GPS_Database"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(roomCallback)
                    .build()

            return instance!!
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

            }
        }
    }




}
