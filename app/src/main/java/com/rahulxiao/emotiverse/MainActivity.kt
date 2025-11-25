package com.rahulxiao.emotiverse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.rahulxiao.emotiverse.ui.dashboard.MainDashboardActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.onboardingRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val skipButton = findViewById<MaterialButton>(R.id.btnSkip)
        val startButton = findViewById<MaterialButton>(R.id.btnStart)

        val goToDashboard = View.OnClickListener {
            startActivity(Intent(this, MainDashboardActivity::class.java))
            finish()
        }

        skipButton.setOnClickListener(goToDashboard)
        startButton.setOnClickListener(goToDashboard)
    }
}