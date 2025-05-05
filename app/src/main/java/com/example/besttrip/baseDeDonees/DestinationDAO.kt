package com.example.besttrip.baseDeDonees

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DestinationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDestination(destinations: List<Destination>)

    @Query("SELECT * FROM Destination WHERE type= :type AND activite = :activite and climat = :climat limit 1")
    suspend fun getByPreference(type: String, activite: String, climat: String): Destination?

    @Query("SELECT * FROM Destination")
    suspend fun getAllDestinations(): List<Destination>
}