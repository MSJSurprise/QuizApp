package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val ivImage: ImageView = findViewById(R.id.iv_image)
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        val tvProgress: TextView = findViewById(R.id.tv_progress)
        val tvOptionOne: TextView = findViewById(R.id.tv_option_one)
        val tvOptionTwo: TextView = findViewById(R.id.tv_option_two)
        val tvOptionThree: TextView = findViewById(R.id.tv_option_three)
        val tvOptionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        val questionList = Constants.getQuestions()
        Log.i("Questions Size", "${questionList.size}")

        val currentPosition = 1
        val question: Question = questionList[currentPosition - 1]

        progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition / ${progressBar.max}"

        tvQuestion.text = question.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

    }
}