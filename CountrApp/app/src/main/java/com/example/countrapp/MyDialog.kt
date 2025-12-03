package com.example.countrapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.countrapp.databinding.DialogExitBinding // Penting! Untuk Custom Dialog

class MyDialog {

    class DatePicker : DialogFragment() {
        // ... (kode DatePicker kamu sudah benar)
    }

    class TimePicker : DialogFragment() {
        // ... (kode TimePicker kamu sudah benar)
    }

    class DialogExit : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(requireActivity())
            val inflater = requireActivity().layoutInflater

            // Pastikan layout 'dialog_exit.xml' sudah dibuat di folder res/layout
            val binding = DialogExitBinding.inflate(inflater)

            with(binding) {
                btnYes.setOnClickListener { requireActivity().finish() }
                btnNo.setOnClickListener { dismiss() }
            }
            builder.setView(binding.root)
            return builder.create()
        }
    }
}