package com.example.hallotoast // (Sesuaikan dengan nama paket kamu)

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hallotoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1. Siapkan variabel binding
    private lateinit var binding: ActivityMainBinding
    // 2. Siapkan variabel angka awal = 0
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. Aktifkan Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. Logika program dimulai di sini
        with(binding) {
            // Set angka awal ke layar
            txtNumber.text = number.toString()

            // Aksi kalau tombol COUNT dipencet
            btnCount.setOnClickListener {
                number++ // Tambah angka
                txtNumber.text = number.toString() // Update layar
            }

            // Aksi kalau tombol TOAST dipencet
            btnToast.setOnClickListener {
                // Munculkan pesan Toast
                Toast.makeText(this@MainActivity, "Count $number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}