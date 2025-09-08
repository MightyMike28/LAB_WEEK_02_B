package com.example.lab_week_02_b

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    companion object {
        const val COLOR_KEY = "COLOR_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField = findViewById<TextInputEditText>(R.id.color_code_input_field)
        val submitButton = findViewById<Button>(R.id.submit_button)

        submitButton.setOnClickListener {
            val colorCode = inputField.text.toString()

            if (colorCode.isEmpty()) {
                Toast.makeText(this, getString(R.string.color_code_input_empty), Toast.LENGTH_LONG).show()
            } else if (colorCode.length < 6) {
                Toast.makeText(this, getString(R.string.color_code_input_wrong_length), Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(COLOR_KEY, colorCode)
                startActivity(intent)
            }
        }
    }
}
