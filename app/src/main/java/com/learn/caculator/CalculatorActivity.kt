package com.learn.caculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.learn.tictactoe.R
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    //TODO disable soft input keyboard on editfocus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        window.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)

    }

    fun buttonNumberEvent(view: View) {
        val buttonSelected: Button = view as Button
        var buttonClick: String = editNumEntry.text.toString()

        when (buttonSelected.id) {
            button0.id -> {
                buttonClick += "0"
            }
            button1.id -> {
                buttonClick += "1"
            }
            button2.id -> {
                buttonClick += "2"
            }
            button3.id -> {
                buttonClick += "3"
            }
            button4.id -> {
                buttonClick += "4"
            }
            button5.id -> {
                buttonClick += "5"
            }
            button6.id -> {
                buttonClick += "6"
            }
            button7.id -> {
                buttonClick += "7"
            }
            button8.id -> {
                buttonClick += "8"
            }
            button9.id -> {
                buttonClick += "9"
            }
            buttonDot.id -> {
                if(!buttonClick.contains(".")){
                    buttonClick += "."
                }
            }
            buttonPlusMinus.id -> {
                buttonClick ="-"+buttonClick
            }
        }
        editNumEntry.setText(buttonClick)
    }

    var opSelected = "-"

    fun buttonNumberManipulation(view : View){
        val buttonSelected: Button = view as Button

        when (buttonSelected.id) {
            buttonAdd.id -> {
                opSelected = "+"
            }
            buttonSub.id -> {
                opSelected = "-"
            }
            buttonMultiply.id -> {
                opSelected = "*"
            }
            buttonDivide.id -> {
                opSelected = "/"
            }
        }
    }

    fun equalToButtonClick(view: View){

    }
}
