package com.ack.quizapptest

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ack.quizapptest.databinding.ActivityQuizQuestionsBinding
import com.ack.quizapptest.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra(Constants.userName)
        binding.tvName.text = username
        val totalQuestions = intent.getIntExtra(Constants.totalQuestions, 0)
        val correctAnswers = intent.getIntExtra(Constants.correctAnswers,0)

        binding.tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"
        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}