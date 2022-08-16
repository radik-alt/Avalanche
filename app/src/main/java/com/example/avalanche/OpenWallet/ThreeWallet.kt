package com.example.avalanche.OpenWallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.avalanche.R

class ThreeWallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_wallet)

        var click: Button = findViewById(R.id.clickIntent)
        var idColor = resources.getColor(R.color.twoPrimaryColor)

        click.setOnClickListener {
            click.background = ContextCompat.getDrawable(this, R.drawable.ic_btnviewprocess)
            click.setTextColor(idColor)
            Thread(Runnable {
                Thread.sleep(100)
                var nextFinal = Intent(this, FinalWallet::class.java)
                startActivity(nextFinal)
                finish()
            }).start()
        }
    }
}