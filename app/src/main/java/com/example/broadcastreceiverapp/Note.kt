package com.example.broadcastreceiverapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    var id: Int = 0,
    var title: String? = "",
    var body: String? = ""
) :Parcelable