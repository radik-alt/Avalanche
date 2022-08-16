package com.example.avalanche.Home

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.avalanche.R

class SendAvax : AppCompatActivity() {

    private lateinit var back: ImageButton
    private lateinit var clickSend: LinearLayout
    private lateinit var phraseText: EditText
    private lateinit var warringOne: TextView
    private lateinit var warringTwo: TextView
    private lateinit var avaxBallSend: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_avax)
        back = findViewById(R.id.back)
        clickSend = findViewById(R.id.clickIntentSend)
        phraseText = findViewById(R.id.phrase)
        warringOne = findViewById(R.id.warringSendOne)
        warringTwo = findViewById(R.id.warringSendTwo)
        avaxBallSend = findViewById(R.id.avaxBallSend)

        back.setOnClickListener {
            val backIntents = Intent(this, HomeActivity::class.java)
            startActivity(backIntents)
            finish()
        }



        clickSend.setOnClickListener {
            if (valid()){
                avaxBallSend.setTextColor(Color.BLACK)
                phraseText.background = ContextCompat.getDrawable(this, R.drawable.input_card)
                warringOne.visibility = View.INVISIBLE
                warringTwo.visibility = View.INVISIBLE
            } else {
                avaxBallSend.setTextColor(Color.RED)
                phraseText.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)
                warringOne.visibility = View.VISIBLE
                warringTwo.visibility = View.VISIBLE
            }
        }

    }

    fun valid () : Boolean{
        var temp = phraseText.text.toString()
        var temp2 = avaxBallSend.text.toString()
        if (temp.isNotBlank() and temp2.isNotBlank()){
            return true
        }
        return false
    }
}