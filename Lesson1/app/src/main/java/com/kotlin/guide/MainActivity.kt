package com.kotlin.guide

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton : Button = findViewById(R.id.btn_lesson1)
        myButton.text = "Lets roll";
        myButton.setOnClickListener {
            rollDice()

        }
    }

    private fun rollDice() {
        val resultText : TextView = findViewById(R.id.result_text)
        val randomInt = Random.nextInt(6) + 1
//        resultText.text = randomInt.toString()

        val diceRolled = when(randomInt){
            1 -> "Dice Rolled 1"
            2 -> "Dice Rolled 2"
            3 -> "Dice Rolled 3"
            4 -> "Dice Rolled 4"
            5 -> "Dice Rolled 5"
            else ->
                "Dice Rolled 6"
        }
        resultText.text = diceRolled
    }
}
