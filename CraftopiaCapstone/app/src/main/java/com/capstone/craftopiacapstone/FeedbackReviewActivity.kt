package com.capstone.craftopiacapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.RatingBar
import android.widget.TextView


class FeedbackReviewActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var ratingBar: RatingBar
    private lateinit var numRating: TextView
    private lateinit var feedbackListAdapter: FeedbackListAdapter
    private var feedbackList = mutableListOf<Feedback>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_review)

        listView = findViewById(R.id.listView)
        ratingBar = findViewById(R.id.ratingBar)
        numRating = findViewById(R.id.numRating)

        feedbackListAdapter = FeedbackListAdapter(this, feedbackList)
        listView.adapter = feedbackListAdapter

        ratingBar.isClickable = false
        ratingBar.isFocusable = false
        ratingBar.setOnTouchListener { _, _ -> true }

        val btnRev: Button = findViewById(R.id.btn_rev)
        val btnBack: ImageButton = findViewById(R.id.btn_bak)

        btnRev.setOnClickListener {
            openFeedbackDialog()
        }

        btnBack.setOnClickListener{
            startActivity(Intent(this, CraftingProductActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openFeedbackDialog() {
        val feedbackDialog = FeedbackDialogFragment()
        feedbackDialog.show(supportFragmentManager, "FeedbackDialog")
    }

    fun submitFeedback(rating: Float, feedback: String) {
        updateRatingBarAndNumRating(rating)

        val newFeedback = Feedback(rating, feedback)
        feedbackList.add(newFeedback)

        feedbackListAdapter.notifyDataSetChanged()
    }

    private fun updateRatingBarAndNumRating(rating: Float) {
        val newAverageRating = calculateAverageRating(rating)

        ratingBar.rating = newAverageRating
        numRating.text = String.format("%.1f", newAverageRating)
    }

    private fun calculateAverageRating(newRating: Float): Float {
        var totalRating = newRating
        for (feedback in feedbackList) {
            totalRating += feedback.rating
        }
        return totalRating / (feedbackList.size + 1)
    }
}