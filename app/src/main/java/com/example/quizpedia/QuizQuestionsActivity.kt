package com.example.quizpedia

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.DEFAULT_BOLD
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition: Int =1
    private var mQuestionsList: ArrayList<Questions>? =null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnsCount: Int = 0
    private var mUserName : String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList= Constants.getQuestions()

        val tv_optionOne = findViewById<TextView>(R.id.tv_optionOne)
        val tv_optionTwo = findViewById<TextView>(R.id.tv_optionTwo)
        val tv_optionThree = findViewById<TextView>(R.id.tv_optionThree)
        val tv_optionFour = findViewById<TextView>(R.id.tv_optionFour)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

        setQuestion()


    }
    fun setQuestion(){

        val question: Questions? = mQuestionsList!![mCurrentPosition - 1]
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        defaultOptionView()
        if (mCurrentPosition == mQuestionsList!!.size){

            btn_submit.text = "Finish"
        }else{
            btn_submit.text = "Submit"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_flag = findViewById<ImageView>(R.id.iv_flag)
        val tv_optionOne = findViewById<TextView>(R.id.tv_optionOne)
        val tv_optionTwo = findViewById<TextView>(R.id.tv_optionTwo)
        val tv_optionThree = findViewById<TextView>(R.id.tv_optionThree)
        val tv_optionFour = findViewById<TextView>(R.id.tv_optionFour)

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + "${progressBar.max}"

        tv_question.text = question!!.questions
        iv_flag.setImageResource(question.img)

        tv_optionOne.text = question.optionOne
        tv_optionTwo.text = question.optionTwo
        tv_optionThree.text = question.optionThree
        tv_optionFour.text = question.optionFour
    }



    private fun defaultOptionView(){

        val tv_optionOne = findViewById<TextView>(R.id.tv_optionOne)
        val tv_optionTwo = findViewById<TextView>(R.id.tv_optionTwo)
        val tv_optionThree = findViewById<TextView>(R.id.tv_optionThree)
        val tv_optionFour = findViewById<TextView>(R.id.tv_optionFour)

        val options = ArrayList<TextView>()
        options.add(0,tv_optionOne)
        options.add(1,tv_optionTwo)
        options.add(2,tv_optionThree)
        options.add(3,tv_optionFour)

        for (option in options){

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.tv_like_button
            )
        }
    }

    fun selectedOptionView(tv: TextView, selectedOptionNum :Int){

        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.color_change_tv)


    }

    fun answerView(answer:Int, drawableView: Int) {

        val tv_optionOne = findViewById<TextView>(R.id.tv_optionOne)
        val tv_optionTwo = findViewById<TextView>(R.id.tv_optionTwo)
        val tv_optionThree = findViewById<TextView>(R.id.tv_optionThree)
        val tv_optionFour = findViewById<TextView>(R.id.tv_optionFour)

        when(answer){

            1 -> {
                tv_optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_optionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_optionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }
    }

    override fun onClick(v: View?) {

        val tv_optionOne = findViewById<TextView>(R.id.tv_optionOne)
        val tv_optionTwo = findViewById<TextView>(R.id.tv_optionTwo)
        val tv_optionThree = findViewById<TextView>(R.id.tv_optionThree)
        val tv_optionFour = findViewById<TextView>(R.id.tv_optionFour)
        val btn_submit = findViewById<Button>(R.id.btn_submit)


        when(v?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(tv_optionOne,1)
            }
            R.id.tv_optionTwo ->{
                selectedOptionView(tv_optionTwo,2)
            }
            R.id.tv_optionThree ->{
                selectedOptionView(tv_optionThree,3)
            }
            R.id.tv_optionFour ->{
                selectedOptionView(tv_optionFour,4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size  ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java )
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANS, mCorrectAnsCount)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                        startActivity(intent)
                        }
                    }
                }else  {
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if( question!!.correctOption != mSelectedOptionPosition){

                        answerView(mSelectedOptionPosition!!,R.drawable.wrong_option)
                    }else{
                        mCorrectAnsCount ++
                    }
                    answerView(question!!.correctOption , R.drawable.correct_option)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "Finish"
                    }else{
                        btn_submit.text = "Go to next question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}

