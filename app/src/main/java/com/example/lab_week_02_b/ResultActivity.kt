package com.example.lab_week_02_b

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val colorCode = intent.getStringExtra(MainActivity.COLOR_KEY)
        val backgroundScreen = findViewById<ConstraintLayout>(R.id.background_screen)
        val resultMessage = findViewById<TextView>(R.id.color_code_result_message)
        val backButton = findViewById<Button>(R.id.back_button)

        try {
            backgroundScreen.setBackgroundColor(Color.parseColor("#$colorCode"))
            resultMessage.text = getString(R.string.color_code_result_message, colorCode?.uppercase())
        } catch (e: Exception) {
            resultMessage.text = getString(R.string.color_code_input_invalid)
            backgroundScreen.setBackgroundColor(Color.GRAY)
        }

        backButton.setOnClickListener {
            finish() // kembali ke MainActivity tanpa restart aplikasi
        }
    }
}
