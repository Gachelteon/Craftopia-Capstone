package com.capstone.craftopiacapstone

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks

class LogActivity : AppCompatActivity() {
    private lateinit var btnlog : Button
    private lateinit var clickHeret: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        val check: CheckBox = findViewById(R.id.checkBox)

        val user1: EditText = findViewById(R.id.text_user)
        val pass1: EditText = findViewById(R.id.text_pass)

        btnlog = findViewById(R.id.btn_enter)

        check.setOnClickListener{
            if(check.isChecked){
                pass1.inputType = 1
            }
            else
                pass1.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        btnlog.setOnClickListener {
            val username = user1.text.toString()
            val password = pass1.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                btnlog.text = "Logging in..."

                btnlog.isEnabled = false

                simulateLogin(username, password)
            }
        }

        linkSetup()
    }

    private fun simulateLogin(username: String, password: String) {
        val delayMillis = 2000L
        val loggedIn = true

        btnlog.postDelayed({
            btnlog.isEnabled = true

            if (loggedIn) {
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("USERNAME", username)
                    putExtra("PASSWORD", password)
                }
                startActivity(intent)
            } else {
                btnlog.text = "Continue"
            }
        }, delayMillis)
    }

    private fun linkSetup() {
        clickHeret = findViewById(R.id.clickHere)

        val clickHereLink = Link("Click Here")
            .setTextColor(Color.BLUE)
            .setTextColorOfHighlightedLink(Color.CYAN)
            .setHighlightAlpha(.4f)
            .setUnderlined(false)
            .setBold(false)
            .setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        clickHeret.applyLinks(clickHereLink)
    }
}