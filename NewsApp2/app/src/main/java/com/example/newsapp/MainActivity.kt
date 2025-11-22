package com.example.newsapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class News(
        val title: String,
        val content: String,
        val imageRes: Int
    )

    private val newsList = listOf(
        News(
            "Bitcoin Anjlok ke 84.601 USD",
            "Bitcoin turun 0,29% pada Sabtu malam...",
            R.drawable.news
        ),
        News(
            "Ethereum Menguat 3%",
            "Ethereum kembali bangkit setelah koreksi...",
            R.drawable.news2
        ),
        News(
            "Solana Mencapai Volume Tertinggi",
            "Solana menarik perhatian investor besar...",
            R.drawable.news3
        )
    )

    private var newsIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        updateNews()

        findViewById<Button>(R.id.btn_next).setOnClickListener {
            if (newsIndex < newsList.size - 1) {
                newsIndex++
                updateNews()
            }
        }

        findViewById<Button>(R.id.btn_prev).setOnClickListener {
            if (newsIndex > 0) {
                newsIndex--
                updateNews()
            }
        }
    }

    private fun updateNews() {
        val current = newsList[newsIndex]

        findViewById<TextView>(R.id.txt_title_news).text = current.title
        findViewById<TextView>(R.id.txt_content_news).text = current.content
        findViewById<ImageView>(R.id.img_news).setImageResource(current.imageRes)
    }
}
