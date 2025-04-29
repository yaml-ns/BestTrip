package com.example.besttrip

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var initText: TextView
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        initText = findViewById(R.id.progressBarText)
        progressBar.max = 100
        simulateProgress()
    }

    private fun simulateProgress() {
        Thread {
            for (i in 0..100) {
                Thread.sleep(50)

                handler.post {
                    progressBar.progress = i
                    initText.text = "Initialisation $i%"
                    if (i == 100) {
                        progressBar.visibility = View.GONE
                        startActivity(Intent(this, PreferenceActivity::class.java))
                    }
                }
            }
        }.start()
    }
}