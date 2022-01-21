package com.example.broadcastreceiverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlin.text.StringBuilder

class NoteBroadcastReceiver(private val callback: (String)->Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        callback(StringBuilder().apply {
            append("Создана новая заметка! ")
            append(intent?.getStringExtra(BROADCAST_MESSAGE).toString() + "\n")
        }.toString())
    }

    companion object {
        private const val BROADCAST_MESSAGE = "title"
    }
}
