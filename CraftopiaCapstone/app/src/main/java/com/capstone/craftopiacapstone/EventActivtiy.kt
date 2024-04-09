package com.capstone.craftopiacapstone

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class EventActivtiy : AppCompatActivity() {
    private lateinit var nextToCalendar: ImageButton
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var buttonToggle: ImageButton
    private lateinit var navigationView: NavigationView
    private lateinit var navBarBottom: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_activtiy)

        nextToCalendar = findViewById(R.id.next2)
        drawerLayout = findViewById(R.id.drawerLayout)
        buttonToggle = findViewById(R.id.drawerToggle)
        navigationView = findViewById(R.id.navigation_view)
        navBarBottom = findViewById(R.id.navbar_bottom)

        nextToCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
        buttonToggle.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.creations -> {
                    Toast.makeText(applicationContext, "Handcraft Creations", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, CraftActivity::class.java))
                }
                R.id.tools -> {
                    Toast.makeText(applicationContext, "Crafting Tools", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, CraftingToolsActivity::class.java))
                }
                R.id.calendar -> {
                    Toast.makeText(applicationContext, "Event Calendar", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, EventActivtiy::class.java))
                }
                R.id.logout -> {
                    Toast.makeText(applicationContext, "Logout", Toast.LENGTH_SHORT).show()
                    navigateToLogin()
                }
            }
            true
        }
        navBarBottom.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }

                R.id.nav -> {
                    // Start for NavigationActivity
                    Toast.makeText(this, "Navigation Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.fav -> {
                    // Start for FavoritesActivity
                    Toast.makeText(this, "Favorites Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.order -> {
                    // Start for OrderlistActivity
                    startActivity(Intent(this, OrderlistActivity::class.java))
                    true
                }

                R.id.profile -> {
                    // Start for ProfileActivity
                    Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }
    private fun navigateToLogin() {
        val intent = Intent(this, LogActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}