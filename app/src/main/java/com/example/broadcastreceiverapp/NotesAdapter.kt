package com.example.broadcastreceiverapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.broadcastreceiverapp.databinding.NoteItemBinding

class NotesAdapter(context: Context) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private var list: List<String> = ArrayList()
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            NoteItemBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: NotesAdapter.NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private val binding: NoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.title.text = data
        }
    }
}
