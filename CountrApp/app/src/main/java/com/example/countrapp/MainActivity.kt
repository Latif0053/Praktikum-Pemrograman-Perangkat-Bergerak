package com.example.countrapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.countrapp.databinding.ActivityMainBinding


// Implement Listener untuk menangkap hasil pilihan tanggal & waktu [cite: 58, 76]
class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var provinces: Array<String>

    // Data dummy untuk spinner negara [cite: 14]
    private val countries = arrayOf(
        "Indonesia", "United States", "United Kingdom", "Germany", "France",
        "Australia", "Japan", "China", "Brazil", "Canada"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup SPINNER
        provinces = resources.getStringArray(R.array.provinces) // Ambil dari strings.xml [cite: 14]

        with(binding) {
            // Adapter untuk Spinner Negara (dari array kode) [cite: 14]
            val adapterCountry =
                ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, countries)
            adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCountry.adapter = adapterCountry

            // Adapter untuk Spinner Provinsi (dari xml) [cite: 14]
            val adapterProvinces = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, provinces)
            adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerProvinces.adapter = adapterProvinces

            // Event saat item Spinner dipilih [cite: 18]
            spinnerCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity, countries[position], Toast.LENGTH_SHORT).show()
                }
                override fun onNothingSelected(parent: AdapterView<*>) {}
            }

            // 2. Setup BUTTON DATE PICKER
            btnShowCalendar.setOnClickListener {
                // Panggil langsung nama class barunya
                val datePicker = MyDatePicker()
                datePicker.show(supportFragmentManager, "datePicker")
            }

            // 3. Setup BUTTON TIME PICKER
            btnShowTimePicker.setOnClickListener {
                val timePicker = MyTimePicker()
                timePicker.show(supportFragmentManager, "timePicker")
            }

            // 4. Setup ALERT DIALOG (Standar) [cite: 84]
            btnShowAlertDialog.setOnClickListener {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Keluar")
                builder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
                builder.setPositiveButton("Ya") { _, _ -> finish() }
                builder.setNegativeButton("Tidak") { dialog, _ -> dialog.dismiss() }
                builder.create().show()
            }

            // 5. Setup CUSTOM DIALOG
            btnShowCustomDialog.setOnClickListener {
                val dialog = MyExitDialog()
                dialog.show(supportFragmentManager, "dialogExit")
            }
        }
    }

    // Callback saat tanggal dipilih [cite: 58]
    override fun onDateSet(view: android.widget.DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = "$dayOfMonth/${month + 1}/$year"
        Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show()
    }

    // Callback saat jam dipilih [cite: 76]
    override fun onTimeSet(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
        Toast.makeText(this, selectedTime, Toast.LENGTH_SHORT).show()
    }
}