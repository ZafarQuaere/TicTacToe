package com.learn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.caculator.CalculatorActivity
import com.learn.navigation.NavigationActivity
import com.learn.sunset.SunsetActivity
import com.learn.tictactoe.R
import com.learn.tictactoe.TicTacToeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTicTacToe.setOnClickListener {
            startActivity(Intent(this,TicTacToeActivity::class.java))
        }
        btnCalculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }

        btnGetSunset.setOnClickListener {
            startActivity(Intent(this, SunsetActivity::class.java))
        }
        btnNavigationDemo.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java));
        }
    }
}
