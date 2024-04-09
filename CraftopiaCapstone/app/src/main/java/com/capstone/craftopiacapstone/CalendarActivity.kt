package com.capstone.craftopiacapstone


import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity


class CalendarActivity : AppCompatActivity() {
    private var mCalendarView: CalendarView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        mCalendarView = findViewById<View>(R.id.calendarView) as CalendarView

        val calendar = Calendar.getInstance()
        calendar.set(2024, Calendar.JANUARY, 1)
        val initialDateInMillis = calendar.timeInMillis
        mCalendarView!!.date = initialDateInMillis

        mCalendarView!!.setOnDateChangeListener { calendarView, i, i1, i2 ->
            val date = (i1 + 1).toString() + "/" + i2 + "/" + i
            Log.d(
                TAG,
                "onSelectedDayChange: mm/dd/yyyy: $date"
            )
        }
    }
    companion object {
        private const val TAG = "CalendarActivity"
    }
}