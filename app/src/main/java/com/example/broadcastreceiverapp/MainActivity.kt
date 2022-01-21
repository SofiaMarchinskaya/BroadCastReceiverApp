package com.example.broadcastreceiverapp

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.broadcastreceiverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notesListAdapter: NotesAdapter
    private val viewModel by lazy { ViewModelProvider(this)[NotesListViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider, null))
        registerReceiver(
            NoteBroadcastReceiver(viewModel::insertDataToList),
            IntentFilter().apply { addAction("com.sofiamarchinskaya.hw1.NOTE_SENT") })
        notesListAdapter =
            NotesAdapter(this)
        binding.notesList.adapter = notesListAdapter
        binding.notesList.addItemDecoration(dividerItemDecoration)

        viewModel.list.observe(this) {
            notesListAdapter.update(it)
        }

    }
}