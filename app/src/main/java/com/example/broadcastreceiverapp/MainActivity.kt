package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textField)
        registerReceiver(NoteBroadcastReceiver(this::onDataReceived), IntentFilter().apply { addAction("com.sofiamarchinskaya.hw1.NOTE_SENT") })
    }
    private fun onDataReceived(text:String){
        this.text.text = text
    }

}