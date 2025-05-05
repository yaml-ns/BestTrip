package com.example.besttrip.baseDeDonees

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DestinationDonnees {

    suspend fun seedIfNeeded(context: Context): Boolean = withContext(Dispatchers.IO) {
        val dao = AppDatabase.getDatabase(context).destinationDao()
        val existing = dao.getAllDestinations()
        if (existing.isEmpty()) {
            dao.insertDestination(getAll())
            true
        } else {
            false
        }
    }

    private fun getAll(): List<Destination> {
        return listOf(
                    Destination(
                        nom = "Santorini",
                        type = "plage",
                        activite = "détente",
                        climat = "tropical",
                        lat = 36.3932,
                        lon = 25.4615,
                        image = "santorini",
                        description = "Île grecque célèbre pour ses maisons blanches, ses dômes bleus et ses couchers de soleil à couper le souffle."

                    ),
                    Destination(
                        nom = "Tokyo",
                        type = "ville",
                        activite = "culture",
                        climat = "tempéré",
                        lat = 35.6895,
                        lon = 139.6917,
                        image = "tokyo",
                        description = "Capitale du Japon, alliant tradition et modernité, célèbre pour ses temples et sa technologie."
                    ),
                    Destination(
                        nom = "Banff",
                        type = "montagne",
                        activite = "aventure",
                        climat = "froid",
                        lat = 51.1784,
                        lon = -115.5708,
                        image = "banff",
                        description = "Parc national canadien réputé pour ses montagnes majestueuses et ses lacs turquoise."
                    ),
                    Destination(
                        nom = "Marrakech",
                        type = "ville",
                        activite = "culture",
                        climat = "chaud",
                        lat = 31.6295,
                        lon = -7.9811,
                        image = "marrakech",
                        description = "Ville marocaine animée, connue pour ses souks colorés et son architecture historique."
                    ),
                    Destination(
                        nom = "Reykjavik",
                        type = "ville",
                        activite = "détente",
                        climat = "froid",
                        lat = 64.1466,
                        lon = -21.9426,
                        image = "reykjavik",
                        description = "Capitale islandaise, parfaite pour observer les aurores boréales et se détendre dans des sources chaudes."
                    ),
                    Destination(
                        nom = "Bali",
                        type = "plage",
                        activite = "aventure",
                        climat = "tropical",
                        lat = -8.3405,
                        lon = 115.0920,
                        image = "bali",
                        description = "Île indonésienne prisée pour ses plages, ses rizières et ses temples hindous."
                    ),
                    Destination(
                        nom = "Zurich",
                        type = "ville",
                        activite = "détente",
                        climat = "tempéré",
                        lat = 47.3769,
                        lon = 8.5417,
                        image = "zurich",
                        description = "Ville suisse élégante, mêlant art, finance et nature. Parfait pour se distraire et se relaxer."
                    ),
                    Destination(
                        nom = "Machu Picchu",
                        type = "montagne",
                        activite = "aventure",
                        climat = "tempéré",
                        lat = -13.1631,
                        lon = -72.5450,
                        image = "machupicchu",
                        description = "Ancienne cité inca perchée dans les Andes péruviennes. Parfait pour les amateurs d'aventure."
                    ),
                    Destination(
                        nom = "Cape Town",
                        type = "plage",
                        activite = "aventure",
                        climat = "tempéré",
                        lat = -33.9249,
                        lon = 18.4241,
                        image = "capetown",
                        description = "Ville sud-africaine bordée de plages et dominée par la Table Mountain."
                    ),
                    Destination(
                        nom = "Queenstown",
                        type = "montagne",
                        activite = "aventure",
                        climat = "froid",
                        lat = -45.0312,
                        lon = 168.6626,
                        image = "queenstown",
                        description = "Station néo-zélandaise réputée pour ses sports extrêmes et paysages alpins. "
                    ),
                    Destination(
                        nom = "Amsterdam",
                        type = "ville",
                        activite = "culture",
                        climat = "tempéré",
                        lat = 52.3676,
                        lon = 4.9041,
                        image = "amsterdam",
                        description = "Capitale des Pays-Bas, célèbre pour ses canaux et ses musées."
                    ),
                    Destination(
                        nom = "Dubai",
                        type = "ville",
                        activite = "détente",
                        climat = "aride",
                        lat = 25.2048,
                        lon = 55.2708,
                        image = "dubai",
                        description = "Ville futuriste aux gratte-ciel vertigineux et centres commerciaux gigantesques."
                    ),
                    Destination(
                        nom = "Siem Reap",
                        type = "ville",
                        activite = "culture",
                        climat = "tropical",
                        lat = 13.3671,
                        lon = 103.8448,
                        image = "siemreap",
                        description = "Ville cambodgienne donnant accès aux temples d’Angkor."
                    ),
                    Destination(
                        nom = "Cinque Terre",
                        type = "plage",
                        activite = "détente",
                        climat = "tempéré",
                        lat = 44.1211,
                        lon = 9.7096,
                        image = "cinqueterre",
                        description = "Région côtière italienne aux villages colorés perchés sur les falaises."
                    ),
                    Destination(
                        nom = "Yellowstone",
                        type = "montagne",
                        activite = "randonnée",
                        climat = "froid",
                        lat = 44.4280,
                        lon = -110.5885,
                        image = "yellowstone",
                        description = "Premier parc national au monde, célèbre pour ses geysers et sa faune."
                    ),
                    Destination(
                        nom = "Petra",
                        type = "montagne",
                        activite = "culture",
                        climat = "aride",
                        lat = 30.3285,
                        lon = 35.4444,
                        image = "petra",
                        description = "Ancienne cité nabatéenne sculptée dans la roche, en Jordanie."
                    ),
                    Destination(
                        nom = "Málaga",
                        type = "plage",
                        activite = "détente",
                        climat = "chaud",
                        lat = 36.7213,
                        lon = -4.4214,
                        image = "malaga",
                        description = "Ville espagnole bordée de plages et donnant accès aux monuments historiques."
                    ),
                    Destination(
                        nom = "Québec",
                        type = "ville",
                        activite = "culture",
                        climat = "froid",
                        lat = 46.8139,
                        lon = -71.2080,
                        image = "quebec",
                        description = "Ville canadienne francophone au riche patrimoine historique."
                    ),
                    Destination(
                        nom = "Ushuaia",
                        type = "montagne",
                        activite = "aventure",
                        climat = "froid",
                        lat = -54.8019,
                        lon = -68.3030,
                        image = "ushuaia",
                        description = "Ville la plus australe du monde, aux portes de l’Antarctique."
                    ),
                    Destination(
                        nom = "Kyoto",
                        type = "ville",
                        activite = "culture",
                        climat = "tempéré",
                        lat = 35.0116,
                        lon = 135.7681,
                        image = "kyoto",
                        description = "Ancienne capitale impériale du Japon, célèbre pour ses temples et jardins."
                    ),
                    Destination(
                        nom = "Tahiti",
                        type = "plage",
                        activite = "détente",
                        climat = "tropical",
                        lat = -17.6509,
                        lon = -149.4260,
                        image = "tahiti",
                        description = "Île paradisiaque de la Polynésie française, parfaite pour se relaxer."
                    ),
                    Destination(
                        nom = "Meknès",
                        type = "ville",
                        activite = "culture",
                        climat = "aride",
                        lat = 33.8950,
                        lon = -5.5547,
                        image = "meknes",
                        description = "Ville impériale du Maroc, riche en histoire et monuments."
                    ),
                    Destination(
                        nom = "Hallstatt",
                        type = "montagne",
                        activite = "détente",
                        climat = "froid",
                        lat = 47.5613,
                        lon = 13.6481,
                        image = "hallstatt",
                        description = "Charmant village autrichien au bord d’un lac, classé au patrimoine mondial."
                    )
                )
            }
        }