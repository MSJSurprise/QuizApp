package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
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
    private var mCorrectAnswers: Int = 0

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
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion(){
        val question = mQuestionList[mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList.size) {
            btnSubmit.text = "Finish"
        } else {
            btnSubmit.text = "Submit"
        }
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
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0 ) {
                    mCurrentPosition ++

                    when{mCurrentPosition <= mQuestionList.size -> {setQuestion()}
                    else -> {
                        Toast.makeText(this, "You have succefully completed the Quiz",
                            Toast.LENGTH_SHORT).show()}
                    }
                } else {
                    val question = mQuestionList.get(mCurrentPosition - 1)
                    if (question.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList.size) {
                        btnSubmit.text = "Finish"
                    } else {
                        btnSubmit.text = "Go to next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)}
            2 -> {tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)}
            3 -> {tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)}
            4 -> {tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)}
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