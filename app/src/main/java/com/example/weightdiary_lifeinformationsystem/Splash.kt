package com.example.weightdiary_lifeinformationsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setLogo(R.mipmap.launcher)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@Splash, Intro::class.java))
            finish()
        }, 3000)


    }
}