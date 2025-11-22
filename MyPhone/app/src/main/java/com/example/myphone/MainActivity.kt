package com.example.myphone // (Sesuaikan package kamu)

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Cari tombolnya
        val btnBookmark = findViewById<Button>(R.id.btn_bookmark)

        // 2. Kasih aksi kalau diklik
        btnBookmark.setOnClickListener {
            Toast.makeText(this, "HP Berhasil Disimpan ke Bookmark! ⭐", Toast.LENGTH_SHORT).show()
        }
    }
}