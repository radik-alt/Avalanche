package com.example.avalanche.Home

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.avalanche.Name
import com.example.avalanche.R

class HomeActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog
    private lateinit var copysPast: LinearLayout
    private lateinit var copyTextUp: TextView
    private lateinit var names: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        dialog = Dialog(this)
        copysPast = findViewById(R.id.textCopyWithDraw)
        copyTextUp = findViewById(R.id.copyText)
        names = findViewById(R.id.nameHome)

        var temp = Name.FirstName
        names.text = temp

        copysPast.setOnClickListener {
            var myClipboard = this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("simple text", copyTextUp.text)
            myClipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
        }
    }

    fun nextWindow(view: View) {

        when (view.id){
            R.id.send -> {
                var sendIntent = Intent(this, SendAvax::class.java)
                startActivity(sendIntent)
            }

            R.id.receive -> {
                createDialog()
            }

            R.id.buy -> {
                var buyIntent = Intent(this, BuyAvax::class.java)
                startActivity(buyIntent)
            }
        }

    }

    private fun createDialog () {
        dialog.setContentView(R.layout.receive_dialog)
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.registr_input))
//        dialog.getWindow()?.requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false)

        var close : ImageButton = dialog.findViewById(R.id.close)
        close.setOnClickListener {
            dialog.dismiss()
        }

        var hashKey: TextView = dialog.findViewById(R.id.hashKey)
        var copy: ImageButton = dialog.findViewById(R.id.copyPast)
        copy.setOnClickListener {
            var myClipboard = this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("simple text", hashKey.text)
            myClipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
        }

        dialog.show()
    }

    override fun onBackPressed() {

    }
}