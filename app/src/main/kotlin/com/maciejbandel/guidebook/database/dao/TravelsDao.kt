package com.maciejbandel.guidebook.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.maciejbandel.guidebook.database.model.TravelEntity
import com.maciejbandel.guidebook.model.Place
import com.maciejbandel.guidebook.util.Constants.TRAVEL_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface TravelsDao {

    @Query("SELECT * FROM $TRAVEL_TABLE_NAME")
    fun observeTravels(): Flow<List<TravelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaces(places: List<Place>)

}