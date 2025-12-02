package com.rahulxiao.emotiverse.ui.dashboard

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
import com.rahulxiao.emotiverse.ui.settings.SettingsActivity

class MainDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_dashboard)

        val scrollView = findViewById<NestedScrollView>(R.id.dashboardScroll)
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
        // Home is already the current screen
        findViewById<FrameLayout>(R.id.navHome).setOnClickListener {
            Toast.makeText(this, "Already on Home", Toast.LENGTH_SHORT).show()
        }

        // Navigate to AI Activity
        findViewById<FrameLayout>(R.id.navAi).setOnClickListener {
            startActivity(Intent(this, AiActivity::class.java))
        }

        // Navigate to Calendar Activity
        findViewById<FrameLayout>(R.id.navCalendar).setOnClickListener {
            startActivity(Intent(this, CalenderActivity::class.java))
        }

        // Navigate to Settings Activity
        findViewById<FrameLayout>(R.id.navSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}

