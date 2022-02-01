package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import kotlin.text.StringBuilder

class NoteBroadcastReceiver(val callback: (String) -> Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        callback(StringBuilder().apply {
            val sdf = SimpleDateFormat.getDateTimeInstance()
            val currentDate = sdf.format(Date())
            val title = intent?.getStringExtra(TITLE)
            val body = intent?.getStringExtra(TEXT)
            append(title + "\n" + body)
            append(currentDate)
        }.toString())
    }

    companion object {
        private const val TITLE = "title"
        private const val TEXT = "text"
    }
}