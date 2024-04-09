package com.capstone.craftopiacapstone

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import androidx.fragment.app.DialogFragment

class FeedbackDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.dialog_feedback, null)

            val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
            val fbEditText = view.findViewById<EditText>(R.id.feedbackEditText)

            builder.setView(view)
                .setTitle("Customer Feedback")
                .setPositiveButton("Submit") { dialog, which ->
                    val rating = ratingBar.rating
                    val feedback = fbEditText.text.toString()
                    (activity as FeedbackReviewActivity).submitFeedback(rating, feedback)
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}