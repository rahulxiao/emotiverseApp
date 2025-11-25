package com.rahulxiao.emotiverse.ui.calender

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
import com.rahulxiao.emotiverse.ui.ai.AiActivity
import com.rahulxiao.emotiverse.ui.dashboard.MainDashboardActivity

class CalenderActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.calender_activity)

        // Set up window insets for edge-to-edge display
        val scrollView = findViewById<NestedScrollView>(R.id.calendarScroll)
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
        
        // Set up week navigation buttons
        setupWeekNavigation()
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
        }

        // Calendar is already the current screen, so just show a message
        findViewById<FrameLayout>(R.id.navCalendar).setOnClickListener {
            // Already on calendar, no action needed
            Toast.makeText(this, "Already on Calendar", Toast.LENGTH_SHORT).show()
        }

        // Navigate to Settings (placeholder - you can create SettingsActivity later)
        findViewById<FrameLayout>(R.id.navSettings).setOnClickListener {
            Toast.makeText(this, "Settings coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupWeekNavigation() {
        // Previous week button
        findViewById<AppCompatImageButton>(R.id.btnPrevWeek).setOnClickListener {
            // TODO: Implement previous week logic
            Toast.makeText(this, "Previous week", Toast.LENGTH_SHORT).show()
        }

        // Next week button
        findViewById<AppCompatImageButton>(R.id.btnNextWeek).setOnClickListener {
            // TODO: Implement next week logic
            Toast.makeText(this, "Next week", Toast.LENGTH_SHORT).show()
        }
    }
}
