package com.maciejbandel.guidebook.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maciejbandel.guidebook.database.dao.TravelsDao
import com.maciejbandel.guidebook.database.model.TravelEntity

@Database(
    entities = [TravelEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GuidebookDatabase : RoomDatabase() {
    abstract fun getTravelsDao(): TravelsDao
}
