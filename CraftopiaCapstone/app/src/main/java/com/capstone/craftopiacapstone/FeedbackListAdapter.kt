package com.capstone.craftopiacapstone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RatingBar
import android.widget.TextView

class FeedbackListAdapter(private val context: Context, private val feedbackList: List<Feedback>) : BaseAdapter() {

    override fun getCount(): Int {
        return feedbackList.size
    }

    override fun getItem(position: Int): Feedback {
        return feedbackList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.feedback_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val feedback = getItem(position)

        viewHolder.ratingBar.rating = feedback.rating
        viewHolder.feedbackTextView.text = "Anonymous: ${feedback.feedbackText}"

        return view!!
    }

    private class ViewHolder(view: View) {
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        val feedbackTextView: TextView = view.findViewById(R.id.feedbackTextView)
    }
}
