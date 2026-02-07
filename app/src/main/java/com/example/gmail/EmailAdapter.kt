package com.example.gmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: MutableList<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    // Track which emails have been read (by position). Simple approach for the lab.
    private val readPositions = mutableSetOf<Int>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderImageView: ImageView = itemView.findViewById(R.id.senderIv)
        val senderTextView: TextView = itemView.findViewById(R.id.senderTv)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTv)
        val summaryTextView: TextView = itemView.findViewById(R.id.summaryTv)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]

        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.dateTextView.text = email.date

        // Simple icon for everyone (lab says same icon is fine)
        holder.senderImageView.setImageResource(android.R.drawable.sym_def_app_icon)

        val isRead = readPositions.contains(position) || !email.isUnread
        val style = if (isRead) Typeface.NORMAL else Typeface.BOLD

        holder.senderTextView.setTypeface(null, style)
        holder.titleTextView.setTypeface(null, style)
        holder.summaryTextView.setTypeface(null, style)
        holder.dateTextView.setTypeface(null, style)

        // Tap to mark as read
        holder.itemView.setOnClickListener {
            readPositions.add(position)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = emails.size
}
