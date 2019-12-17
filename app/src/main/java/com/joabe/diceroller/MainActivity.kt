package com.joabe.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result_text)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.countUp_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        var currentText = resultText.text.toString()
        if (resources.getString(R.string.hello_world).equals(currentText)) {
            currentText = "1"
        } else if (!"6".equals(currentText)) {
            currentText = (Integer.parseInt(currentText) + 1).toString()
        }
        resultText.text = currentText
    }

    private fun reset() {
        resultText.text = "0"
    }
}
