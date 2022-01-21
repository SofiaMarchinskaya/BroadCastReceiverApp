package com.example.broadcastreceiverapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesListViewModel : ViewModel() {
    val list = MutableLiveData<MutableList<String>>(mutableListOf())
    private val new_list = mutableListOf<String>()

    fun insertDataToList(title: String) {
        list.value = new_list.apply { add(title) }
    }
}