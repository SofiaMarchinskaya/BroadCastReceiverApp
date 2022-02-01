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
            intent?.extras?.classLoader=Note::class.java.classLoader
            val note:Note? = intent?.extras?.getParcelable(BROADCAST_MESSAGE)
            append(note?.title + "\n" + note?.body)
            append(currentDate)
        }.toString())
    }

    companion object {
        private const val BROADCAST_MESSAGE = "note"
    }
}
