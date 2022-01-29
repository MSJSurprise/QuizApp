package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView
    private lateinit var btnSubmit: Button

    private var mCurrentPosition: Int = 1
    private lateinit var mQuestionList: ArrayList<Question>
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

         tvQuestion = findViewById(R.id.tv_question)
         ivImage = findViewById(R.id.iv_image)
         progressBar = findViewById(R.id.progress_bar)
         tvProgress = findViewById(R.id.tv_progress)
         tvOptionOne = findViewById(R.id.tv_option_one)
         tvOptionTwo = findViewById(R.id.tv_option_two)
         tvOptionThree = findViewById(R.id.tv_option_three)
         tvOptionFour = findViewById(R.id.tv_option_four)
         btnSubmit = findViewById(R.id.btn_submit)

         mQuestionList = Constants.getQuestions()

        setQuestion()
        tvOptionOne.setOnClickListener (this)
        tvOptionTwo.setOnClickListener (this)
        tvOptionThree.setOnClickListener (this)
        tvOptionFour.setOnClickListener (this)
        btnSubmit.setOnClickListener (this)

    }

    private fun setQuestion(){
        mCurrentPosition = 1
        val question = mQuestionList[mCurrentPosition - 1]

        defaultOptionView()

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition / ${progressBar.max}"

        tvQuestion.text = question.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {selectedOptionView(tvOptionOne, 1)}
            R.id.tv_option_two -> {selectedOptionView(tvOptionTwo, 2)}
            R.id.tv_option_three -> {selectedOptionView(tvOptionThree, 3)}
            R.id.tv_option_four -> {selectedOptionView(tvOptionFour, 4)}
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }

}