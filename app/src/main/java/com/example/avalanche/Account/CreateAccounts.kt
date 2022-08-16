package com.example.avalanche.Account

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.avalanche.CreateAccount.KeyStoreFile
import com.example.avalanche.CreateAccount.PrivateKey
import com.example.avalanche.CreateAccount.StoreFile
import com.example.avalanche.OpenWallet.FinalWallet
import com.example.avalanche.R
import javax.net.ssl.HandshakeCompletedEvent

class CreateAccounts : AppCompatActivity() {

    private lateinit var cardKey: CardView
    private lateinit var phraseKey : CardView
    private lateinit var CardFile: CardView
    private lateinit var textKey: TextView
    private lateinit var textPhrase: TextView
    private lateinit var textFile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_accounts)
        cardKey = findViewById(R.id.privetKey)
        phraseKey = findViewById(R.id.privatePhrase)
        textKey = findViewById(R.id.textKey)
        textPhrase = findViewById(R.id.textPhrase)
        textFile = findViewById(R.id.textFile)
        CardFile = findViewById(R.id.privateFile)

        var back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            var back = Intent(this, FinalWallet::class.java)
            startActivity(back)
        }



    }

    fun typeRegistr(view: View) {

        when (view.id) {
            R.id.privateKeyLiner -> {
                cardKey.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                textKey.setTextColor(Color.BLACK)
                Thread(Runnable {
                    Thread.sleep(100)
                    var intentPrivate = Intent(this, PrivateKey::class.java)
                    startActivity(intentPrivate)
                }).start()

            }

            R.id.linerKeystore -> {
                CardFile.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                textFile.setTextColor(Color.BLACK)
                Thread(Runnable {
                    Thread.sleep(100)
                    var intentPrivate = Intent(this, StoreFile::class.java)
                    startActivity(intentPrivate)
                }).start()
            }

            R.id.linerMnemonic -> {
                phraseKey.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                textPhrase.setTextColor(Color.BLACK)
                Thread(Runnable {
                    Thread.sleep(100)
                    var intentPhrase = Intent(this, KeyStoreFile::class.java)
                    startActivity(intentPhrase)
                }).start()

            }
        }
    }
}