package com.example.avalanche.Home

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.avalanche.R

class BuyAvax : AppCompatActivity() {

    private lateinit var back: ImageButton
    private lateinit var clickBuy: LinearLayout

    private lateinit var cardNumber: EditText
    private lateinit var cardDate: EditText
    private lateinit var cardCVS: EditText

    private lateinit var warringOne: TextView
    private lateinit var warringTwo: TextView
    private lateinit var avaxBallBuy: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_avax)
        back = findViewById(R.id.back)
        clickBuy = findViewById(R.id.clickIntentPrivate)
        avaxBallBuy = findViewById(R.id.avaxBallBuy)
        cardNumber = findViewById(R.id.card)
        cardDate = findViewById(R.id.date)
        cardCVS = findViewById(R.id.CVS)
        warringOne = findViewById(R.id.warringBuyOne)
        warringTwo = findViewById(R.id.warringBuyTwo)

        clickBuy.setOnClickListener {
            if (valid()){
                avaxBallBuy.setTextColor(Color.BLACK)
                warringOne.visibility = View.INVISIBLE
                warringTwo.visibility = View.INVISIBLE
                cardNumber.background = ContextCompat.getDrawable(this, R.drawable.input_card)
                cardDate.background = ContextCompat.getDrawable(this, R.drawable.input_card)
                cardCVS.background = ContextCompat.getDrawable(this, R.drawable.input_card)

            } else {
                avaxBallBuy.setTextColor(Color.RED)
                cardNumber.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)
                cardDate.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)
                cardCVS.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)

                warringOne.visibility = View.VISIBLE
                warringTwo.visibility = View.VISIBLE
            }
        }

        back.setOnClickListener {
            val backIntents = Intent(this, HomeActivity::class.java)
            startActivity(backIntents)
            finish()
        }

    }

    fun valid () : Boolean {
        var ball = avaxBallBuy.text.toString()
        var cardNum = cardNumber.text.toString()
        var cardDate = cardDate.text.toString()
        var CVS = cardCVS.text.toString()
        if (ball.isNotBlank() and cardNum.isNotBlank()
            and cardDate.isNotBlank() and CVS.isNotBlank()){
            return true
        }
        return false
    }

}