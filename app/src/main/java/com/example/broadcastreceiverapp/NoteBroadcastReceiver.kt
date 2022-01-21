package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import kotlin.text.StringBuilder

class NoteBroadcastReceiver(val callback: (String)->Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        callback(StringBuilder().apply {
            val sdf = SimpleDateFormat.getDateTimeInstance()
            val currentDate = sdf.format(Date())
            append(intent?.getStringExtra(BROADCAST_MESSAGE).toString()+"\n")
            append(currentDate)
        }.toString())
    }

    companion object {
        private const val BROADCAST_MESSAGE = "title"
    }
}
