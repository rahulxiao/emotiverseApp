package com.rahulxiao.emotiverse.ui.ai

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.NestedScrollView
import com.rahulxiao.emotiverse.R
import com.rahulxiao.emotiverse.ui.calender.CalenderActivity
import com.rahulxiao.emotiverse.ui.dashboard.MainDashboardActivity
import com.rahulxiao.emotiverse.ui.settings.SettingsActivity

class AiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ai_activity)

        val scrollView = findViewById<NestedScrollView>(R.id.aiScroll)
        ViewCompat.setOnApplyWindowInsetsListener(scrollView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Back button
        findViewById<AppCompatImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Set up bottom navigation (if AI activity has bottom nav)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        // Navigate to Home (Dashboard)
        findViewById<FrameLayout>(R.id.navHome)?.setOnClickListener {
            startActivity(Intent(this, MainDashboardActivity::class.java))
            finish()
        }

        // AI is already the current screen
        findViewById<FrameLayout>(R.id.navAi)?.setOnClickListener {
            Toast.makeText(this, "Already on AI", Toast.LENGTH_SHORT).show()
        }

        // Navigate to Calendar Activity
        findViewById<FrameLayout>(R.id.navCalendar)?.setOnClickListener {
            startActivity(Intent(this, CalenderActivity::class.java))
        }

        // Navigate to Settings Activity
        findViewById<FrameLayout>(R.id.navSettings)?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }
    }
}


