package com.rahulxiao.emotiverse.ui.settings

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.NestedScrollView
import com.rahulxiao.emotiverse.R
import com.rahulxiao.emotiverse.ui.ai.AiActivity
import com.rahulxiao.emotiverse.ui.calender.CalenderActivity
import com.rahulxiao.emotiverse.ui.dashboard.MainDashboardActivity

class SettingsActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.settings_activity)

        val scrollView = findViewById<NestedScrollView>(R.id.settingsScroll)
        ViewCompat.setOnApplyWindowInsetsListener(scrollView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Set up bottom navigation
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        // Navigate to Home (Dashboard)
        findViewById<FrameLayout>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, MainDashboardActivity::class.java))
            finish()
        }

        // Navigate to AI Activity
        findViewById<FrameLayout>(R.id.navAi).setOnClickListener {
            startActivity(Intent(this, AiActivity::class.java))
            finish()
        }

        // Navigate to Calendar Activity
        findViewById<FrameLayout>(R.id.navCalendar).setOnClickListener {
            startActivity(Intent(this, CalenderActivity::class.java))
            finish()
        }

        // Settings is already the current screen
        findViewById<FrameLayout>(R.id.navSettings).setOnClickListener {
            Toast.makeText(this, "Already on Settings", Toast.LENGTH_SHORT).show()
        }
    }
}

