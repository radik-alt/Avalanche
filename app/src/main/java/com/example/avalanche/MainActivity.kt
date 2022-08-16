package com.example.avalanche

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.avalanche.OpenWallet.FirstWallet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var click : ImageButton = findViewById(R.id.next)
        click.setOnClickListener {
            click.setImageResource(R.drawable.ic_clicknext2)
            var next = Intent (this, FirstWallet::class.java)
            startActivity(next)

        }
    }
}