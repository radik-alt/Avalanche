package com.example.avalanche.OpenWallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.avalanche.R

class TwoWallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_wallet)

        var click: ImageButton = findViewById(R.id.clickIntent)
        click.setOnClickListener {
            click.setImageResource(R.drawable.ic_clicknext2)
            Thread(Runnable {
                Thread.sleep(100)
                var next: Intent = Intent(this, ThreeWallet::class.java)
                startActivity(next)
                finish()
            }).start()

        }
    }
}