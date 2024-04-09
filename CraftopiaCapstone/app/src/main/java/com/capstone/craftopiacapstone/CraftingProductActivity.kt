package com.capstone.craftopiacapstone

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks

class CraftingProductActivity : AppCompatActivity() {
    private lateinit var navBarBottom: BottomNavigationView
    private lateinit var backBtn: ImageButton
    private lateinit var artLink: TextView
    private lateinit var msgBtn: ImageButton
    private lateinit var orderBtn: Button
    private lateinit var buyBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crafting_product)

        navBarBottom = findViewById(R.id.navbar_bottom)
        backBtn = findViewById(R.id.backP)
        msgBtn = findViewById(R.id.messageBtn)
        orderBtn = findViewById(R.id.orderBtn)
        buyBtn = findViewById(R.id.buyBtn)

        msgBtn.setOnClickListener {
            Toast.makeText(this, "Direct Message CLicked!", Toast.LENGTH_SHORT).show()
        }

        orderBtn.setOnClickListener {
            Toast.makeText(this, "Added to Order!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, OrderlistActivity::class.java))
        }

        buyBtn.setOnClickListener {
            Toast.makeText(this, "Buy Now Clicked!", Toast.LENGTH_SHORT).show()
        }

        backBtn.setOnClickListener {
            startActivity(Intent(this, CraftActivity::class.java))
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
        linkSetup()
    }

    private fun linkSetup() {
        artLink = findViewById(R.id.artistList)

        val clickHereLink = Link("Ladakh's Wood Carving")
            .setTextColor(Color.BLUE)
            .setTextColorOfHighlightedLink(Color.CYAN)
            .setHighlightAlpha(.4f)
            .setUnderlined(true)
            .setBold(false)
            .setOnClickListener {
                val intent = Intent(this, FeedbackReviewActivity::class.java)
                startActivity(intent)
            }
        artLink.applyLinks(clickHereLink)
    }
}