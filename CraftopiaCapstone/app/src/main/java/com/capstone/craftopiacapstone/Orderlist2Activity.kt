package com.capstone.craftopiacapstone

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Orderlist2Activity : AppCompatActivity() {
    private lateinit var backBtn: ImageButton
    private lateinit var navBarBottom: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderlist2)

        backBtn = findViewById(R.id.back2)
        navBarBottom = findViewById(R.id.navbar_bottom)

        backBtn.setOnClickListener {
            startActivity(Intent(this, OrderlistActivity::class.java))
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
}