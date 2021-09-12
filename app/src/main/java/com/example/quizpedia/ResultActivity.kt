package com.example.quizpedia

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name_result = findViewById<TextView>(R.id.tv_name_result)
        val tv_score = findViewById<TextView>(R.id.tv_score)


        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_name_result.text = username

        val correctAns = intent.getIntExtra(Constants.CORRECT_ANS, 0)
        val totalAns = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        tv_score.text ="Your score is $correctAns out of $totalAns"
    }

    fun btn_end(view: android.view.View){
        startActivity(Intent(this, MainActivity::class.java))
    }
}