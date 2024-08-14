package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var playerTurn = true
    var singleUser = false
    var player1Count = 0
    var player2Count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn10 = findViewById<Button>(R.id.button10)
        btn10.setOnClickListener {
            reset()
        }
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var emptyCells = ArrayList<Int>()
    var activeUser = 1

    fun clickfun(view: View) {
        if (playerTurn) {
            val but = view as Button
            var cellID = 0
            when (but.id) {
                R.id.button -> cellID = 1
                R.id.button2 -> cellID = 2
                R.id.button3 -> cellID = 3
                R.id.button4 -> cellID = 4
                R.id.button5 -> cellID = 5
                R.id.button6 -> cellID = 6
                R.id.button7 -> cellID = 7
                R.id.button8 -> cellID = 8
                R.id.button9 -> cellID = 9
            }
            playerTurn = false
            Handler().postDelayed({ playerTurn = true }, 600)
            playnow(but, cellID)
        }
    }

    fun playnow(buttonSelected: Button, currCell: Int) {

        if (activeUser == 1) {
            buttonSelected.text = "X"
            buttonSelected.setTextColor(Color.parseColor("#EC0C0C"))
            player1.add(currCell)
            emptyCells.add(currCell)
            buttonSelected.isEnabled = false
            val checkWinner = checkwinner()

            if (checkWinner == 1) {
                Handler().postDelayed({ reset() }, 2000)
            } else if (singleUser) {
                Handler().postDelayed({ robot() }, 500)
            } else {
                activeUser = 2
            }
        } else {
            buttonSelected.text = "O"
            buttonSelected.setTextColor(Color.parseColor("#D22BB804"))
            activeUser = 1
            player2.add(currCell)
            emptyCells.add(currCell)
            buttonSelected.isEnabled = false
            val checkWinner = checkwinner()
            if (checkWinner == 1)
                Handler().postDelayed({ reset() }, 4000)
        }
    }

    fun reset() {
        player1.clear()
        player2.clear()
        emptyCells.clear()
        activeUser = 1
        for (i in 1..9) {
            var buttonselected: Button? = null
            when (i) {
                1 -> buttonselected = findViewById(R.id.button)
                2 -> buttonselected = findViewById(R.id.button2)
                3 -> buttonselected = findViewById(R.id.button3)
                4 -> buttonselected = findViewById(R.id.button4)
                5 -> buttonselected = findViewById(R.id.button5)
                6 -> buttonselected = findViewById(R.id.button6)
                7 -> buttonselected = findViewById(R.id.button7)
                8 -> buttonselected = findViewById(R.id.button8)
                9 -> buttonselected = findViewById(R.id.button9)
            }
            buttonselected?.isEnabled = true
            buttonselected?.text = ""
            val textView = findViewById<TextView>(R.id.textView)
            val textView2 = findViewById<TextView>(R.id.textView2)
            textView.text = "Player1 : $player1Count"
            textView2.text = "Player2 : $player2Count"
        }
    }

    fun disableReset() {
        val button10 = findViewById<Button>(R.id.button10)
        button10.isEnabled = false
        Handler().postDelayed({ button10.isEnabled = true }, 2200)
    }

    fun robot() {
        val rnd = (1..9).random()
        if (emptyCells.contains(rnd))
            robot()
        else {
            val buttonselected: Button? = when (rnd) {
                1 -> findViewById(R.id.button)
                2 -> findViewById(R.id.button2)
                3 -> findViewById(R.id.button3)
                4 -> findViewById(R.id.button4)
                5 -> findViewById(R.id.button5)
                6 -> findViewById(R.id.button6)
                7 -> findViewById(R.id.button7)
                8 -> findViewById(R.id.button8)
                9 -> findViewById(R.id.button9)
                else -> findViewById(R.id.button)
            }
            emptyCells.add(rnd)
            buttonselected?.text = "O"
            buttonselected?.setTextColor(Color.parseColor("#D22BB804"))
            player2.add(rnd)
            buttonselected?.isEnabled = false
            var checkWinner = checkwinner()
            if (checkWinner == 1)
                Handler().postDelayed({ reset() }, 2000)
        }
    }
    fun checkwinner(): Int {
        return 0
    }
}
