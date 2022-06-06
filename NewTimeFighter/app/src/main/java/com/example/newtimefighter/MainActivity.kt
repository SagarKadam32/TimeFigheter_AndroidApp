package com.example.newtimefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal var score = 0
    internal var timeLeft = 0
    internal lateinit var tapMeButton: Button
    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeLeftTextView: TextView

    internal var gameStarted = false

    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown: Long = 60000
    internal var countDownInterval: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tapMeButton = findViewById(R.id.tapMeButton)
        gameScoreTextView = findViewById(R.id.yourScore)
        timeLeftTextView = findViewById(R.id.timeLeft)

        resetGame()
        tapMeButton.setOnClickListener { view ->
            incrementScore()
        }
    }

    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.yourScore,score)

        val initialTimeLeft = initialCountDown / 1000
        timeLeftTextView.text = getString(R.string.timeLeft,initialTimeLeft)

        countDownTimer = object : CountDownTimer(initialCountDown,countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timeLeftTextView.text = getString(R.string.timeLeft, timeLeft)
            }
            override fun onFinish() {
            }
        }
        gameStarted = false
    }

    private fun incrementScore() {
        score += 1
        val newScore = getString(R.string.yourScore, score)
        gameScoreTextView.text = newScore
    }
}