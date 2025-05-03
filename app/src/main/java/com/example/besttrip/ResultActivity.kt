package com.example.besttrip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.besttrip.baseDeDonees.Destination
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ResultActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private var googleMaps: GoogleMap? = null
    private lateinit var imageDestination: ImageView
    private lateinit var textDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mapView = findViewById(R.id.mapViewResult)
        imageDestination = findViewById(R.id.imageResult)
        textDetails = findViewById(R.id.textDetails)

        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        val nom = intent.getStringExtra("nom") ?: ""
        val type = intent.getStringExtra("type") ?: ""
        val activite = intent.getStringExtra("activite") ?: ""
        val climat = intent.getStringExtra("climat") ?: ""
        val lat = intent.getDoubleExtra("lat", 0.0)
        val lon = intent.getDoubleExtra("lon", 0.0)
        val btnCopier = findViewById<Button>(R.id.btnCopier)
        val btnMaps = findViewById<Button>(R.id.btnMaps)
        val sousTitre = findViewById<TextView>(R.id.textSousTitre)
        sousTitre.text = "$type - $climat - $activite"
        val description = intent.getStringExtra("description") ?: ""
        findViewById<TextView>(R.id.textDescription).text = description

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        btnCopier.setOnClickListener {
            val coords = "$lat, $lon"
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clip = android.content.ClipData.newPlainText("Coordonnées", coords)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Coordonnées copiées", Toast.LENGTH_SHORT).show()
        }

        btnMaps.setOnClickListener {
            val gmmIntentUri = android.net.Uri.parse("geo:$lat,$lon?q=$lat,$lon($nom)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        val imageName = intent.getStringExtra("image") ?: ""
        val resId = resources.getIdentifier(imageName.lowercase(), "drawable", packageName)
        if (resId != 0) {
            imageDestination.setImageResource(resId)
        } else {
            imageDestination.setImageResource(R.drawable.amsterdam)
        }

        textDetails.text = nom
    }

    override fun onMapReady(map: GoogleMap) {
        googleMaps = map

        val lat= intent.getDoubleExtra("lat", 0.0)
        val lon = intent.getDoubleExtra("lon", 0.0)
        val location = LatLng(lat, lon)

        googleMaps?.addMarker(MarkerOptions().position(location).title("Destination"))

        googleMaps?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 6f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}