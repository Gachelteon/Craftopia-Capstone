package com.capstone.craftopiacapstone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class OrderlistActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var buttonToggle: ImageButton
    private lateinit var navigationView: NavigationView
    private lateinit var navBarBottom: BottomNavigationView
    private lateinit var orderOne: ImageView
    private lateinit var notificationBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderlist)

        orderOne = findViewById(R.id.list1)
        notificationBtn = findViewById(R.id.notification)
        drawerLayout = findViewById(R.id.drawerLayout)
        buttonToggle = findViewById(R.id.drawerToggle)
        navigationView = findViewById(R.id.navigation_view)
        navBarBottom = findViewById(R.id.navbar_bottom)

        orderOne.setOnClickListener{
            startActivity(Intent(this, Orderlist2Activity::class.java))
        }

        notificationBtn.setOnClickListener {
            // Store the class name of the current activity in shared preferences
            val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("lastActivity", javaClass.name)
            editor.apply()

            startActivity(Intent(this, NotificationActivity::class.java))
        }

        buttonToggle.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.books -> {
                    Toast.makeText(applicationContext, "E-Readers and Books Clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.appstore -> {
                    Toast.makeText(applicationContext, "Craftopia Appstore Clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.creations -> {
                    Toast.makeText(applicationContext, "Handcraft Creations", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, CraftActivity::class.java))
                }
                R.id.raw -> {
                    Toast.makeText(applicationContext, "Raw Materials Clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.tools -> {
                    Toast.makeText(applicationContext, "Crafting Tools", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, CraftingToolsActivity::class.java))
                }
                R.id.collab -> {
                    Toast.makeText(applicationContext, "Collaboration and Connect Clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.calendar -> {
                    Toast.makeText(applicationContext, "Event Calendar", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, EventActivtiy::class.java))
                }
                R.id.workshop -> {
                    Toast.makeText(applicationContext, "Skill Workshop Clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.forum -> {
                    Toast.makeText(applicationContext, "Community Forum Clicked!", Toast.LENGTH_SHORT).show()
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
                    // Start for CartActivity
                    Toast.makeText(this, "Order List Clicked", Toast.LENGTH_SHORT).show()
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