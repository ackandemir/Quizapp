package com.ack.quizapptest

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ack.quizapptest.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mUserName = intent.getStringExtra(Constants.userName)

        mQuestionsList = Constants.getQuestions()
        setQuestion() // burdan emin degilim

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)

        binding.btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion() {

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView() // bundan da emin degilim

        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "${mCurrentPosition} / ${binding.progressBar.max}"

        if(mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit.text = "FINISH"
        }
        else{
            binding.btnSubmit.text = "SUBMIT"
        }



        binding.tvQuestions.text = question!!.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question!!.optionOne
        binding.tvOptionTwo.text = question!!.optionTwo
        binding.tvOptionThree.text = question!!.optionThree
        binding.tvOptionFour.text = question!!.optionFour

    }


    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(binding.tvOptionFour,4)
            }

            R.id.btnSubmit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.userName, mUserName)
                            intent.putExtra(Constants.correctAnswers, mCorrectAnswers)
                            intent.putExtra(Constants.totalQuestions, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
                else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++

                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        binding.btnSubmit.text = "FINISH"
                    }
                    else {
                        binding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }
            }

        }
    }



    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }


    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1-> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2-> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3-> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4-> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

}