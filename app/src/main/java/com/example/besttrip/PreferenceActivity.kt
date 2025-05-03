package com.example.besttrip

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.besttrip.baseDeDonees.AppDatabase
import com.example.besttrip.baseDeDonees.Destination
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PreferenceActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var typeSpinner: Spinner
    private lateinit var activitySpinner: Spinner
    private lateinit var climatSpinner: Spinner

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)


        typeSpinner = findViewById(R.id.typeSpinner)
        activitySpinner = findViewById(R.id.activitySpinner)
        climatSpinner = findViewById(R.id.climatSpinner)

        db = AppDatabase.getDatabase(this)

        populateSpinners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        findViewById<Button>(R.id.boutonDestination).setOnClickListener {
            val type = typeSpinner.selectedItem.toString()
            val activite = activitySpinner.selectedItem.toString()
            val climat = climatSpinner.selectedItem.toString()

            lifecycleScope.launch {
                val result = db.destinationDao().getByPreference(type, activite, climat)

                val destinationFinale = result ?: db.destinationDao().getAllDestinations().randomOrNull()

                withContext(Dispatchers.Main) {
                    if (destinationFinale != null) {
                        val titre = if (result != null) "Destination trouvée" else "Suggestion aléatoire"
                        val message = if (result != null)
                            "Votre destination personnalisée : ${destinationFinale.nom}"
                        else
                            "Aucune correspondance exacte. Suggestion : ${destinationFinale.nom}"

                        AlertDialog.Builder(this@PreferenceActivity)
                            .setTitle(titre)
                            .setMessage(message)
                            .setPositiveButton("Voir") { dialog, _ ->
                                ouvrirResultActivity(destinationFinale)
                                dialog.dismiss()
                            }
                            .setNegativeButton("Annuler") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .show()
                    } else {
                        Toast.makeText(this@PreferenceActivity, "Aucune destination disponible.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
    }

    private fun ouvrirResultActivity(dest: Destination) {
        val intent = Intent(this@PreferenceActivity, ResultActivity::class.java).apply {
            putExtra("nom", dest.nom)
            putExtra("image", dest.image)
            putExtra("lat", dest.lat)
            putExtra("lon", dest.lon)
            putExtra("type", dest.type)
            putExtra("climat", dest.climat)
            putExtra("activite", dest.activite)
            putExtra("description", dest.description)
        }
        startActivity(intent)
    }
        private fun populateSpinners() {
        lifecycleScope.launch {
            val all = db.destinationDao().getAllDestinations()
            val types = all.map { it.type }.distinct()
            val activites = all.map { it.activite }.distinct()
            val climats = all.map { it.climat }.distinct()

            withContext(Dispatchers.Main) {
                typeSpinner.adapter = ArrayAdapter(
                    this@PreferenceActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    listOf("Sélectionner un type...") + types
                )
                activitySpinner.adapter = ArrayAdapter(
                    this@PreferenceActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    listOf("Sélectionner une activité...") + activites
                )
                climatSpinner.adapter = ArrayAdapter(
                    this@PreferenceActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    listOf("Sélectionner un climat...") + climats
                )
            }

        }
    }
}
