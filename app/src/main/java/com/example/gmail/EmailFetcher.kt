package com.example.gmail

class EmailFetcher {
    companion object {
        private val senders = listOf(
            "Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes",
            "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval",
            "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould"
        )

        private val dates = listOf(
            "Feb 1", "Feb 2", "Feb 3", "Feb 4", "Feb 5",
            "Feb 6", "Feb 7", "Feb 8", "Feb 9", "Feb 10",
            "Feb 11", "Feb 12", "Feb 13", "Feb 14", "Feb 15"
        )

        private const val title = "Welcome to Kotlin!"
        private const val summary =
            "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."

        fun getEmails(): MutableList<Email> {
            val emails: MutableList<Email> = ArrayList()
            for (i in 0..9) {
                val unread = (i % 2 == 0) // alternate unread/read
                emails.add(Email(senders[i], title, summary, dates[i], unread))
            }
            return emails
        }

        fun getNext5Emails(): MutableList<Email> {
            val newEmails: MutableList<Email> = ArrayList()
            for (i in 10..14) {
                val unread = true
                newEmails.add(Email(senders[i], title, summary, dates[i], unread))
            }
            return newEmails
        }
    }
}
