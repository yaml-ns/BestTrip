# BestTrip

Best Trip est une application de voyage personnalisé, conçue pour offrir une expérience utilisateur fluide et intuitive.
Ce projet vise à simplifier la recherche de destinations pour les voyageurs en leur proposant des suggestions personnalisées selon leurs préférences.

## Fonctionnalités

* **Recherche personnalisée** : Trouvez des destinations selon le type (ville, plage, montagne), l'activité (culture, détente, aventure) et le climat.
* **Fiches détaillées** : Consultez des informations complètes sur chaque destination avec images et descriptions.
* **Localisation géographique** : Visualisez l'emplacement exact des destinations sur une carte interactive.
* **Intégration Google Maps** : Ouvrez directement l'itinéraire dans Google Maps ou copiez les coordonnées.
* **Interface utilisateur intuitive** : Navigation fluide et design moderne pour une expérience agréable.

## Technologies utilisées

* **Frontend** : XML, Material Design
* **Backend** : Kotlin
* **Base de données** : Room (SQLite)
* **Localisation** : Google Maps API
* **Framework UI** : AndroidX, ConstraintLayout
* **Animation** : AnimationUtils

## Installation

```bash
git clone https://github.com/APVinc/BestTrip.git
cd BestTrip
# Ouvrir le projet dans Android Studio
# Synchroniser le projet avec Gradle
# Configurer une clé API Google Maps dans le fichier local.properties
# Compiler et exécuter sur un émulateur ou appareil Android
```

## Structure du projet

L'application suit une architecture moderne avec séparation des responsabilités :
* **Activities** : MainActivity, PreferenceActivity, ResultActivity
* **Base de données** : AppDatabase, Destination, DestinationDAO, DestinationDonnees
* **Layouts** : activity_main.xml, activity_preference.xml, activity_result.xml, dialog_result.xml
