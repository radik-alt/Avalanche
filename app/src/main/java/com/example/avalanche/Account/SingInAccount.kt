package com.example.avalanche.Account

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.avalanche.Name
import com.example.avalanche.OpenWallet.FinalWallet
import com.example.avalanche.R

class SingInAccount : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var password: EditText
    private lateinit var back: ImageButton
    private lateinit var nextStage: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        name = findViewById(R.id.FirstName)
        password = findViewById(R.id.password)
        back = findViewById(R.id.back)
        nextStage = findViewById(R.id.createAccount)

        var isName = false
        var isPassword = false

        name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("CHANGETEXT", p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isName = true
                Log.d("CHANGETEXT", p0.toString())
                if (p0?.length == 0){
                    isName = false
                    Log.d("CHANGETEXT", "Пустой edit")
                }

                if (isPassword && isName){
                    nextStage.background = ContextCompat.getDrawable(application, R.drawable.ic_btnview)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        password.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isPassword = true
                Log.d("CHANGEPasss", p0.toString())
                if (p0?.length == 0){
                    isPassword = false
                    Log.d("CHANGEPasss", "Пустой edit")
                }

                if (isPassword && isName){
                    nextStage.background = ContextCompat.getDrawable(application, R.drawable.ic_btnview)
                    nextStage.setTextColor(Color.WHITE)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })




        var idColor = resources.getColor(R.color.twoPrimaryColor)
        nextStage.setOnClickListener {
            var getName:String = name.text.toString()
            var getPassword:String = password.text.toString()
            if (getName.isNotBlank() and getPassword.isNotBlank()) {
                nextStage.background = ContextCompat.getDrawable(this, R.drawable.ic_btnviewprocess)
                nextStage.setTextColor(idColor)
                var temp = Name.Companion
                temp.FirstName = name.text.toString()
                Thread(Runnable {
                    Thread.sleep(1000)
                    val nextStep = Intent(this, CreateAccounts::class.java)
                    startActivity(nextStep)
                    finish()
                }).start()
            }
        }


        back.setOnClickListener {
            var back = Intent(this, FinalWallet::class.java)
            startActivity(back)
        }


    }

    override fun onBackPressed() {
        val backIntent = Intent(this, FinalWallet::class.java)
        startActivity(backIntent)
        finish()
    }
}