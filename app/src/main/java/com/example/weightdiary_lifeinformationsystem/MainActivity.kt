package com.example.weightdiary_lifeinformationsystem

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) !==
            PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            } else {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            }
        }


        val buttonCalc = findViewById<ImageButton>(R.id.bmi)
        buttonCalc.setOnClickListener{
            val intent = Intent(this, BMI::class.java)
            startActivity(intent)
            }
        val buttonDiary = findViewById<ImageButton>(R.id.history)
        buttonDiary.setOnClickListener{
            val intent = Intent(this, Diary::class.java)
            startActivity(intent)
        }
        val buttonAbout = findViewById<ImageButton>(R.id.aboutus)
        buttonAbout.setOnClickListener{
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}