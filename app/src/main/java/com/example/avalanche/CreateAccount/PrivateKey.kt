package com.example.avalanche.CreateAccount

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.avalanche.Account.CreateAccounts
import com.example.avalanche.Account.SingInAccount
import com.example.avalanche.Home.HomeActivity
import com.example.avalanche.OpenWallet.ThreeWallet
import com.example.avalanche.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class PrivateKey : AppCompatActivity() {

    private lateinit var key: TextInputEditText
    private lateinit var click: LinearLayout
    private lateinit var textClick: TextView
    private lateinit var warring: TextView
    private lateinit var inputLayput : TextInputLayout
    private lateinit var backKey : ImageButton
    private lateinit var progress: ProgressBar

    private val CONST_KEY = "KjtuZdptBPXHW4a9PAHCt7nYk6zAwZ6ckzKGz6WSk3PfuPiTxaTy"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_private_key)
        textClick = findViewById(R.id.textIntnetPrivet)
        key = findViewById(R.id.key)
        click = findViewById(R.id.clickIntentPrivate)
        warring = findViewById(R.id.warring)
        inputLayput = findViewById(R.id.inputLayout)
        backKey = findViewById(R.id.backPrivate)
        progress = findViewById(R.id.progressPrivet)

        backKey.setOnClickListener {
            val intentBack = Intent(this, CreateAccounts::class.java)
            startActivity(intentBack)
            finish()
        }

        key.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                warring.visibility = View.INVISIBLE
                key.background = ContextCompat.getDrawable(application, R.drawable.registr_input)
                key.setTextColor(Color.BLACK)
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })


        click.setOnClickListener {

            if (valid()) {
                click.background = ContextCompat.getDrawable(this, R.drawable.ic_btnviewprocess)
                textClick.visibility = View.INVISIBLE
                progress.visibility = View.VISIBLE

                Thread(Runnable {
                    Thread.sleep(1000)
                    var nextStage: Intent = Intent(this, HomeActivity::class.java)
                    startActivity(nextStage)
                    finish()
                }).start()
            } else {
                key.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)
                warring.visibility = View.VISIBLE
                key.setTextColor(Color.RED)
            }
        }

    }

    fun valid () : Boolean {
        var temp = key.text.toString()
        if (temp.equals(CONST_KEY)){
            return true
        }

        return false
    }

    override fun onBackPressed() {
        val intentBack = Intent(this, CreateAccounts::class.java)
        startActivity(intentBack)
        finish()
    }
}