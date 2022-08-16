package com.example.avalanche.CreateAccount

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.avalanche.Account.CreateAccounts
import com.example.avalanche.Account.SingInAccount
import com.example.avalanche.Home.HomeActivity
import com.example.avalanche.R

class KeyStoreFile : AppCompatActivity() {

    private lateinit var warring: TextView
    private lateinit var phrase: EditText
    private lateinit var click: LinearLayout
    private lateinit var colorPhrase : TextView
    private lateinit var progres: ProgressBar
    private lateinit var backFile: ImageButton
    private val CONST_PHARSE = "motion novel over pilot mystery kangaroo reject rice column scatter elder bring"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_store_file)
        phrase = findViewById(R.id.phrase)
        click = findViewById(R.id.phraseIntent)
        warring = findViewById(R.id.warringPhrase)
        colorPhrase = findViewById(R.id.textIntentPhrase)
        progres = findViewById(R.id.progressPhrase)
        backFile = findViewById(R.id.backFilesss)


        phrase.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                deleteWarring()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        backFile.setOnClickListener {
            val intentBack = Intent(this, CreateAccounts::class.java)
            startActivity(intentBack)
            finish()
        }

        var mHanlder = Handler(Looper.myLooper()!!)
        click.setOnClickListener {
            if (valid()){
                Thread(Runnable {
                    mHanlder.post {
                        unpdateLoader()
                    }
                    Thread.sleep(1000)
                    var nextStage = Intent(this, HomeActivity::class.java)
                    startActivity(nextStage)
                }).start()

            } else {
                updateWarring()
            }
        }
    }

    private fun updateWarring () {
        phrase.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)
        warring.visibility = View.VISIBLE
        phrase.setTextColor(Color.RED)
    }

    private fun deleteWarring () {
        warring.visibility = View.INVISIBLE
        phrase.background = ContextCompat.getDrawable(application, R.drawable.registr_input)
        phrase.setTextColor(Color.BLACK)
    }

    private fun unpdateLoader () {
        click.background = ContextCompat.getDrawable(this, R.drawable.ic_btnviewprocess)
        progres.visibility = View.VISIBLE
        colorPhrase.visibility = View.INVISIBLE
    }

    private fun valid () : Boolean {
        var temp = phrase.text.toString()
        if (temp == CONST_PHARSE){
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