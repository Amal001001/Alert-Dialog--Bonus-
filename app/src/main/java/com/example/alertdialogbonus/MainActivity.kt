package com.example.alertdialogbonus

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button:Button
   // lateinit var view:View
    lateinit var textView: TextView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        button = findViewById(R.id.button)
        button.setOnClickListener { customAlert() }

    }

    private fun customAlert(){

        val dialogBuilder = AlertDialog.Builder(this)
        var alert : AlertDialog? = null

        val input = EditText(this)
//        val inputtv = TextView(this)
//        inputtv.text = input.text.toString()

        dialogBuilder.setMessage("Enter your message:")

            .setPositiveButton("tv", DialogInterface.OnClickListener {
                    dialog, id -> textView.text = input.text.toString()
            })
            .setNegativeButton("go", DialogInterface.OnClickListener {
                    dialog, id -> val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("message", input.text.toString())
                    startActivity(intent)
            })

        alert = dialogBuilder.create()

        alert.setTitle("New Message")

        alert.setView(input)

        alert.show()


    }
}