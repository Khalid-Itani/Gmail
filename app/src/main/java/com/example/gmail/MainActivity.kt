package com.example.gmail

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var emails: MutableList<Email>
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)

        emails = EmailFetcher.getEmails()
        adapter = EmailAdapter(emails)

        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            val newEmails = EmailFetcher.getNext5Emails()
            val startPos = emails.size
            emails.addAll(newEmails)
            adapter.notifyItemRangeInserted(startPos, newEmails.size)
        }
    }
}
