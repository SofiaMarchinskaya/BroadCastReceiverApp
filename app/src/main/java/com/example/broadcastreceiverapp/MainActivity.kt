package com.example.broadcastreceiverapp

import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        text = findViewById(R.id.textField)
//        registerReceiver(NoteBroadcastReceiver(this::onDataReceived), IntentFilter().apply { addAction("com.sofiamarchinskaya.hw1.NOTE_SENT") })
    }
//    private fun onDataReceived(text:String){
//        this.text.text = text
//    }

}