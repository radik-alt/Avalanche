package com.example.avalanche

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private var mHandler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mHandler.postDelayed(Runnable {
            var splash = Intent(this, MainActivity::class.java)
            startActivity(splash)
            finish()
        }, 4000)

    }
}