package com.example.besttrip.baseDeDonees

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Destination(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nom: String,
    val type: String,
    val activite: String,
    val climat: String,
    val lat: Double,
    val lon: Double,
    val image: String,
    val description: String
)