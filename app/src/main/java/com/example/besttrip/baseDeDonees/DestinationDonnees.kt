package com.example.besttrip.baseDeDonees

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DestinationDonnees {

    fun getDatabase(context: Context) {
        val db = AppDatabase.getDatabase(context)
        val dao = db.destinationDao()

        CoroutineScope(Dispatchers.IO).launch {
            val existe = dao.getByPreference("plage", "detente", "tropical")
            if (existe == null) {
                val destinations = listOf(
                    Destination(
                        nom = "Santorini",
                        type = "plage",
                        activite = "détente",
                        climat = "tropical",
                        lat = 36.3932,
                        lon = 25.4615,
                        image = "santorini"
                    ),
                    Destination(
                        nom = "Tokyo",
                        type = "ville",
                        activite = "culture",
                        climat = "tempéré",
                        lat = 35.6895,
                        lon = 139.6917,
                        image = "tokyo"
                    ),
                    Destination(
                        nom = "Banff",
                        type = "montagne",
                        activite = "aventure",
                        climat = "froid",
                        lat = 51.1784,
                        lon = -115.5708,
                        image = "banff"
                    ),
                    Destination(
                        nom = "Marrakech",
                        type = "ville",
                        activite = "culture",
                        climat = "chaud",
                        lat = 31.6295,
                        lon = -7.9811,
                        image = "marrakech"
                    ),
                    Destination(
                        nom = "Reykjavik",
                        type = "ville",
                        activite = "détente",
                        climat = "froid",
                        lat = 64.1466,
                        lon = -21.9426,
                        image = "reykjavik"
                    ),
                    Destination(
                        nom = "Bali",
                        type = "plage",
                        activite = "aventure",
                        climat = "tropical",
                        lat = -8.3405,
                        lon = 115.0920,
                        image = "bali"
                    ),
                    Destination(
                        nom = "Zurich",
                        type = "ville",
                        activite = "détente",
                        climat = "tempéré",
                        lat = 47.3769,
                        lon = 8.5417,
                        image = "zurich"
                    ),
                    Destination(
                        nom = "Machu Picchu",
                        type = "montagne",
                        activite = "aventure",
                        climat = "tempéré",
                        lat = -13.1631,
                        lon = -72.5450,
                        image = "machupicchu"
                    ),
                    Destination(
                        nom = "Cape Town",
                        type = "plage",
                        activite = "aventure",
                        climat = "tempéré",
                        lat = -33.9249,
                        lon = 18.4241,
                        image = "capetown"
                    ),
                    Destination(
                        nom = "Queenstown",
                        type = "montagne",
                        activite = "aventure",
                        climat = "froid",
                        lat = -45.0312,
                        lon = 168.6626,
                        image = "queenstown"
                    ),
                    Destination(
                        nom = "Amsterdam",
                        type = "ville",
                        activite = "culture",
                        climat = "tempéré",
                        lat = 52.3676,
                        lon = 4.9041,
                        image = "amsterdam"
                    ),
                    Destination(
                        nom = "Dubai",
                        type = "ville",
                        activite = "détente",
                        climat = "aride",
                        lat = 25.2048,
                        lon = 55.2708,
                        image = "dubai"
                    ),
                    Destination(
                        nom = "Siem Reap",
                        type = "ville",
                        activite = "culture",
                        climat = "tropical",
                        lat = 13.3671,
                        lon = 103.8448,
                        image = "siemreap"
                    ),
                    Destination(
                        nom = "Cinque Terre",
                        type = "plage",
                        activite = "détente",
                        climat = "tempéré",
                        lat = 44.1211,
                        lon = 9.7096,
                        image = "cinqueterre"
                    ),
                    Destination(
                        nom = "Yellowstone",
                        type = "montagne",
                        activite = "randonnée",
                        climat = "froid",
                        lat = 44.4280,
                        lon = -110.5885,
                        image = "yellowstone"
                    ),
                    Destination(
                        nom = "Petra",
                        type = "montagne",
                        activite = "culture",
                        climat = "aride",
                        lat = 30.3285,
                        lon = 35.4444,
                        image = "petra"
                    ),
                    Destination(
                        nom = "Málaga",
                        type = "plage",
                        activite = "détente",
                        climat = "chaud",
                        lat = 36.7213,
                        lon = -4.4214,
                        image = "malaga"
                    ),
                    Destination(
                        nom = "Québec",
                        type = "ville",
                        activite = "culture",
                        climat = "froid",
                        lat = 46.8139,
                        lon = -71.2080,
                        image = "quebec"
                    ),
                    Destination(
                        nom = "Ushuaia",
                        type = "montagne",
                        activite = "aventure",
                        climat = "froid",
                        lat = -54.8019,
                        lon = -68.3030,
                        image = "ushuaia"
                    ),
                    Destination(
                        nom = "Kyoto",
                        type = "ville",
                        activite = "culture",
                        climat = "tempéré",
                        lat = 35.0116,
                        lon = 135.7681,
                        image = "kyoto"
                    ),
                    Destination(
                        nom = "Tahiti",
                        type = "plage",
                        activite = "détente",
                        climat = "tropical",
                        lat = -17.6509,
                        lon = -149.4260,
                        image = "tahiti"
                    ),
                    Destination(
                        nom = "Meknès",
                        type = "ville",
                        activite = "culture",
                        climat = "aride",
                        lat = 33.8950,
                        lon = -5.5547,
                        image = "meknes"
                    ),
                    Destination(
                        nom = "Hallstatt",
                        type = "montagne",
                        activite = "détente",
                        climat = "froid",
                        lat = 47.5613,
                        lon = 13.6481,
                        image = "hallstatt"
                    )
                )
            }
        }
    }

}