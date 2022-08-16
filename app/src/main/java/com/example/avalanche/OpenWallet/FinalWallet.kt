package com.example.avalanche.OpenWallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.avalanche.Account.CreateAccounts
import com.example.avalanche.Account.SingInAccount
import com.example.avalanche.Home.HomeActivity
import com.example.avalanche.R

class FinalWallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_wallet)

        var singin: TextView = findViewById(R.id.singin)
        singin.setOnClickListener {
            var next = Intent(this, CreateAccounts::class.java)
            startActivity(next)
            finish()
        }

        var idColor = resources.getColor(R.color.twoPrimaryColor)
        var create: Button = findViewById(R.id.startedAccount)
        create.setOnClickListener {
            create.background = ContextCompat.getDrawable(this, R.drawable.ic_btnviewprocess)
            create.setTextColor(idColor)
            Thread(Runnable {
                Thread.sleep(100)
                var created = Intent(this, SingInAccount::class.java)
                startActivity(created)
            }).start()
        }
    }
}