package com.example.avalanche.CreateAccount

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.avalanche.Account.CreateAccounts
import com.example.avalanche.Account.SingInAccount
import com.example.avalanche.Home.HomeActivity
import com.example.avalanche.R
import com.google.android.material.textfield.TextInputLayout
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList

class StoreFile : AppCompatActivity() {

    private lateinit var choseFile: Button
    private var fileText: String = ""
    private lateinit var layoutPassword : TextInputLayout
    private lateinit var warring: TextView
    private lateinit var click: LinearLayout
    private lateinit var edxPassword : EditText
    private lateinit var file : TextView
    private lateinit var progress : ProgressBar
    private lateinit var clickText : TextView
    private lateinit var backStore: ImageButton

    private lateinit var mHandler : Handler

    private val finalTextFile = "KjtuZdptBPXHW4a9PAHCt7nYk6zAwZ6ckzKGz6WSk3PfuPiTxaTy"
    private val finalPassword = "dsA31@dfQ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_file)
        init()

        backStore.setOnClickListener {
            val intentBack = Intent(this, CreateAccounts::class.java)
            startActivity(intentBack)
            finish()
        }

        choseFile.setOnClickListener {
            val intent = Intent()
                .setType("text/plain")
                .setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)


        }

        click.setOnClickListener {
            if (validPasswod() and validFile()){
                edxPassword.setTextColor(Color.BLACK)
                layoutPassword.background = ContextCompat.getDrawable(this, R.drawable.registr_input)
                click.background = ContextCompat.getDrawable(this, R.drawable.ic_btnviewprocess)
                progress.visibility = View.VISIBLE
                clickText.visibility = View.INVISIBLE
                warring.visibility = View.INVISIBLE
                Thread(Runnable {
                    Thread.sleep(1000)
                    val fileFinalIntent = Intent(this, HomeActivity::class.java)
                    startActivity(fileFinalIntent)
                }).start()


            } else {
                layoutPassword.background = ContextCompat.getDrawable(this, R.drawable.regist_input_wrong)
                warring.visibility = View.VISIBLE
                edxPassword.setTextColor(Color.RED)
            }
        }
    }

    fun init (){
        backStore = findViewById(R.id.backStore)
        choseFile = findViewById(R.id.choseFile)
        layoutPassword = findViewById(R.id.inputLayoutFile)
        warring = findViewById(R.id.warringFile)
        click = findViewById(R.id.clickIntentFile)
        edxPassword = findViewById(R.id.keyFile)
        file = findViewById(R.id.nameFile)
        progress = findViewById(R.id.progressFile)
        clickText = findViewById(R.id.textIntnetFile)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == RESULT_OK) {
            val selectedFile = data?.data ?: return //The uri with the location of the file
            var listPath = selectedFile.lastPathSegment.toString().split("/")
            var nameFile = listPath.get(listPath.size - 1)
            Log.d("SELECTFILES", nameFile)
            file.text = nameFile

            val inputStream = contentResolver.openInputStream(selectedFile)
            val reader = BufferedReader(InputStreamReader(inputStream))
            var temp = reader.readText()

            Log.d("SELECTEDFILE", temp)
            fileText = temp
            reader.close()
            if (validFile()){
                layoutPassword.visibility = View.VISIBLE
            }
        }
    }

    private fun validFile () : Boolean {
        Log.d("VALIDFILESSSS", "$fileText $finalTextFile")
        if (fileText == finalTextFile){
            return true
        }
        return false
    }

    private fun validPasswod () : Boolean {
        if (edxPassword.text.toString() == finalPassword){
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