package com.example.besttrip

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.besttrip.baseDeDonees.DestinationDonnees
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var initText: TextView
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        initText = findViewById(R.id.progressBarText)
        progressBar.max = 100

        lifecycleScope.launch {

            DestinationDonnees.seedIfNeeded(this@MainActivity)

            simulateProgress()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(0, systemBars.top, 0, 0)
            insets
        }
    }

    private fun simulateProgress() {
        Thread {
            for (i in 0..100) {
                Thread.sleep(30)
                handler.post {
                    progressBar.progress = i
                    initText.text = "Initialisation $i%"
                    if (i == 100) {
                        progressBar.visibility = View.GONE
                        startActivity(Intent(this, PreferenceActivity::class.java))
                        finish()
                    }
                }
            }
        }.start()
    }
}
