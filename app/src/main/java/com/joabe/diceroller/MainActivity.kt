package com.joabe.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var firstDiceImage: ImageView
    lateinit var secondDiceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstDiceImage = findViewById(R.id.first_dice)
        secondDiceImage = findViewById(R.id.second_dice)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clear() }
    }

    private fun rollDice() {
        firstDiceImage.setImageResource(getImageResource(getRandomDiceImage()))
        secondDiceImage.setImageResource(getImageResource(getRandomDiceImage()))
    }

    private fun getRandomDiceImage(): Int {
        return Random().nextInt(6) + 1
    }

    private fun getImageResource(randomInt: Int): Int {
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun clear() {
        firstDiceImage.setImageResource(R.drawable.empty_dice)
        secondDiceImage.setImageResource(R.drawable.empty_dice)
    }
}
