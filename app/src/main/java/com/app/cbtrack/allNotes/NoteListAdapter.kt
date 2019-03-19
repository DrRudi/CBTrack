package com.app.cbtrack.allNotes

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.app.cbtrack.R
import com.app.cbtrack.database.Note
import com.app.cbtrack.dateToString
import android.graphics.LightingColorFilter


class NoteListAdapter internal constructor(context: Context) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notes = emptyList<Note>()
    var itemColor = context.resources.getDrawable(R.drawable.list_item_border);

    var onItemClick: ((Note) -> Unit)? = null

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noteSituation: TextView = itemView.findViewById(R.id.situation_text)
        var dateItemView: TextView = itemView.findViewById(R.id.date_text)
        var itemTypeText: TextView = itemView.findViewById(R.id.item_type)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(notes[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = inflater.inflate(R.layout.activity_all_notes_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = notes[position]
        holder.noteSituation.text = current.situation
        holder.dateItemView.text = dateToString(current.date)
        holder.itemTypeText.text = if(current.noteType == 1) "эмоции" else "мысли"

//        when(current.emotion)
//
//        val filter = LightingColorFilter(Color.BLACK, Color.BLACK)
//        itemColor.setColorFilter(filter)
//        holder.itemView.setBackground(itemColor);
    }

    internal fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun getItemCount() = notes.size
}


