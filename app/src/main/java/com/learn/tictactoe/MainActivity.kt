package com.learn.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var autoPlay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRefersh.setOnClickListener{
            //TODO enable all buttons to default
            //TODO Clear array list
            enableAllButtons()
        }
        btnEnableAutoPlay.setOnClickListener {
            btnEnableAutoPlay.text = if (btnEnableAutoPlay.text.contains("Enable")) {
                autoPlay = true
                "Disable AutoPlay"
            }
            else {
                autoPlay = false
                "Enable AutoPlay"
            }
        }
    }

    private fun enableAllButtons() {
        var occupiedCell = ArrayList<Int>()
        for (cell in 0..9){
            if (player1.contains(cell) || player2.contains(cell)){
               occupiedCell.add(cell)
            }else{
                occupiedCell.add(cell)
            }
        }

        for (cellToClear in 0 until occupiedCell.size){
            when(occupiedCell[cellToClear]){
                1-> {
                    btn1.isEnabled = true
                    btn1.setBackgroundResource(R.color.colorWhite)
                    btn1.text = ""
                }
                2->  {
                    btn2.isEnabled = true
                    btn2.setBackgroundResource(R.color.colorWhite)
                    btn2.text = ""
                }
                3->  {
                    btn3.isEnabled = true
                    btn3.setBackgroundResource(R.color.colorWhite)
                    btn3.text = ""
                }
                4->  {
                    btn4.isEnabled = true
                    btn4.setBackgroundResource(R.color.colorWhite)
                    btn4.text = ""
                }
                5->  {
                    btn5.isEnabled = true
                    btn5.setBackgroundResource(R.color.colorWhite)
                    btn5.text = ""
                }
                6->  {
                    btn6.isEnabled = true
                    btn6.setBackgroundResource(R.color.colorWhite)
                    btn6.text = ""
                }
                7->  {
                    btn7.isEnabled = true
                    btn7.setBackgroundResource(R.color.colorWhite)
                    btn7.text = ""
                }
                8->  {
                    btn8.isEnabled = true
                    btn8.setBackgroundResource(R.color.colorWhite)
                    btn8.text = ""
                }
                9->  {
                    btn9.isEnabled = true
                    btn9.setBackgroundResource(R.color.colorWhite)
                    btn9.text = ""
                }
            }
        }
        player1.clear()
        player2.clear()
        occupiedCell.clear()
    }

    fun buttonClick(view: View) {
        val btnSelected = view as Button
        var cellID = 0
        when (btnSelected.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }

     //   Toast.makeText(this, "Selected Cell $cellID", Toast.LENGTH_SHORT).show()
        playGame(btnSelected, cellID)
    }

    //second player will be auto play
    fun autoPlay(){
        var emptyCell = ArrayList<Int>()
        for (cellID in 1..9){
            if (!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCell.add(cellID)
            }
        }

        val random = Random()
        var randIndex :Int  = try {
            random.nextInt(emptyCell.size - 0)+0
        } catch (e: Exception) {
            return
        }
        val cellId = emptyCell[randIndex]

        val selectedBtn : Button?

        when(cellId){
            1-> selectedBtn = btn1
            2-> selectedBtn = btn2
            3-> selectedBtn = btn3
            4-> selectedBtn = btn4
            5-> selectedBtn = btn5
            6-> selectedBtn = btn6
            7-> selectedBtn = btn7
            8-> selectedBtn = btn8
            9-> selectedBtn = btn9
            else ->{
                selectedBtn = btn1
            }
        }
        playGame(selectedBtn,cellId)


    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(btnSelected: Button, cellID: Int) {

        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.colorBlue)
            player1.add(cellID)
            activePlayer = 2
            if (autoPlay) {
                autoPlay()
            }
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.colorDarkGreen)
            player2.add(cellID)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        checkWinner()

    }

    fun checkWinner() {
        var winner = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        //column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //Cross 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //Cross 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is Winner ", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Player 2 is Winner ", Toast.LENGTH_LONG).show()
            }
            //TODO Once a winner is declared disable all buttons
            disableRemainingButton()
        }
    }

    private fun disableRemainingButton() {
        val emptyCell = ArrayList<Int>()
        for (cell in 0..9){
            if (!(player1.contains(cell) || player2.contains(cell))){
                emptyCell.add(cell)
            }
        }

        for (cellToDisable in 0 until emptyCell.size){
            when(emptyCell[cellToDisable]){
                1-> btn1.isEnabled = false
                2-> btn2.isEnabled = false
                3-> btn3.isEnabled = false
                4-> btn4.isEnabled = false
                5-> btn5.isEnabled = false
                6-> btn6.isEnabled = false
                7-> btn7.isEnabled = false
                8-> btn8.isEnabled = false
                9-> btn9.isEnabled = false
            }
        }
    }
}
