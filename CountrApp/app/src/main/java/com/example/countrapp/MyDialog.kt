package com.example.countrapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.util.Calendar
import com.example.countrapp.databinding.DialogExitBinding

// --- CLASS 1: DATE PICKER ---
// (Berdiri sendiri, tidak di dalam kurung kurawal class lain)
class MyDatePicker : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireActivity(),
            activity as DatePickerDialog.OnDateSetListener,
            year,
            month,
            day
        )
    }
}

// --- CLASS 2: TIME PICKER ---
class MyTimePicker : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            requireActivity(),
            activity as TimePickerDialog.OnTimeSetListener,
            hour,
            minute,
            android.text.format.DateFormat.is24HourFormat(activity)
        )
    }
}

// --- CLASS 3: CUSTOM DIALOG EXIT ---
class MyExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val binding = DialogExitBinding.inflate(inflater)

        with(binding) {
            btnYes.setOnClickListener { requireActivity().finish() }
            btnNo.setOnClickListener { dismiss() }
        }
        builder.setView(binding.root)
        return builder.create()
    }
}