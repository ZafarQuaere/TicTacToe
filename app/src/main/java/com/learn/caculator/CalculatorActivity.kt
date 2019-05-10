package com.learn.caculator

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.learn.tictactoe.R
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    //TODO disable soft input keyboard on editfocus
    //TODO keep old number,Operator and new Number on the display and on = click display the result.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        window.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)

    }

    fun buttonNumberEvent(view: View) {
        if(isNewNumber) {
            editNumEntry.setText("")
        }
        val buttonSelected: Button = view as Button
        var buttonClick: String = editNumEntry.text.toString()
            isNewNumber = false
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
                    if (!buttonClick.contains(".")) {
                        buttonClick += "."
                    }
                }
                buttonPlusMinus.id -> {
                    buttonClick = "-" + buttonClick
                }
            }

        editNumEntry.setText(buttonClick)
    }

    var opSelected = "*"
    var oldNumber = ""
    var isNewNumber = true

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
        isNewNumber = true
        oldNumber = editNumEntry.text.toString()
    }

    fun equalToButtonClick(view: View){
        val newNumber = editNumEntry.text.toString()
        var finalNumber : Double? = null
        when (opSelected) {
            "+" -> {
                finalNumber = newNumber.toDouble() + oldNumber.toInt()
            }
            "-" ->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "*" ->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" ->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
        }

        editNumEntry.setText(finalNumber.toString())
        isNewNumber = true
    }

    fun buttonPercentClick(view: View){
        val number : Double = editNumEntry.text.toString().toDouble()/100
        editNumEntry.setText(number.toString())
        isNewNumber = true
    }

    fun buttonACClick(view: View){
        editNumEntry.setText("0")
        isNewNumber = true
    }
}
