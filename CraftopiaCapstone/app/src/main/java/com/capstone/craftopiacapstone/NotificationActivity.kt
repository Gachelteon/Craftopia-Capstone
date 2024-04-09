package com.capstone.craftopiacapstone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            // Retrieve the class name of the last visited activity from shared preferences
            val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val lastActivityName = sharedPref.getString("lastActivity", "")

            // Start the last visited activity using reflection
            try {
                val lastActivityClass = Class.forName(lastActivityName)
                startActivity(Intent(this, lastActivityClass))
            } catch (e: ClassNotFoundException) {
                // Handle exception (e.g., if the last visited activity class is not found)
                e.printStackTrace()
            }

            finish()
        }
    }
}