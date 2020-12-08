package com.example.weightdiary_lifeinformationsystem

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

@Suppress("DEPRECATION")
class Diary : AppCompatActivity() {
    private lateinit var main: View
    private lateinit var screenshot: ImageView
    fun convertLongToDateString(systemTime: Long): String {
        return SimpleDateFormat("dd/MM/yyyy")
            .format(systemTime).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val database = BMIDatabase.getInstance(applicationContext)
        val delete = findViewById<ImageButton>(R.id.historyReset)
        delete.setOnClickListener {
            database.clearAllTables()
            finish()
            overridePendingTransition(0, 0);
            val intent = Intent(this, Diary::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0);
        }
        val back = findViewById<ImageButton>(R.id.historyBack)
                back.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        val firstDate = findViewById<TextView>(R.id.date1)
        val getDateOne = database.DatabaseDao.loadDateLatest()
        val outputDateOne = convertLongToDateString(getDateOne)
        firstDate.text = outputDateOne

        val firstBMI = findViewById<TextView>(R.id.bmi1)
        val getBMIOne = database.DatabaseDao.loadBMILatest()
        firstBMI.text = getBMIOne.toString()

        val firstWeight = findViewById<TextView>(R.id.weight1)
        val getWeightOne = database.DatabaseDao.loadWeightLatest()
        firstWeight.text = getWeightOne.toString()
        screenshot = findViewById(R.id.screenshot)
        val save = findViewById<ImageButton>(R.id.save)
        save.setOnClickListener{
            val b: Bitmap = Screenshot.takeScreenshotOfRootView(screenshot)
            screenshot.setImageBitmap(b)
            Handler().postDelayed(Runnable { screenshot.visibility = View.GONE}, 3 * 1000)
        }


    }
    companion object Screenshot {
        private fun takeScreenshot(view: View): Bitmap {
            view.isDrawingCacheEnabled = true
            view.buildDrawingCache(true)
            val b = Bitmap.createBitmap(view.drawingCache)
            view.isDrawingCacheEnabled = false
            return b
        }

        fun takeScreenshotOfRootView(v: View): Bitmap {
            return takeScreenshot(v.rootView)
        }
    }
}