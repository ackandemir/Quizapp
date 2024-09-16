package com.ack.quizapptest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ack.quizapptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }

    fun start(view: View) {
        val kullaniciAdi = binding.nameText.text.toString()
        if (kullaniciAdi == "") { // Kullanıcı adi boşsa alttakini yapar
            Toast.makeText(this,"Please enter your name.", Toast.LENGTH_SHORT).show()
        }

        else { // Kullanıcı adı girildiyse bir sonraki sayfaya geçer
            val intent = Intent(this, QuizQuestionsActivity::class.java) //Intent fonksiyonunu kullanarak intent degiskenine sonraki sayfasi atadik
            intent.putExtra(Constants.userName, kullaniciAdi)
            startActivity(intent) // sonraki sayfaya geçiş yaptık
            finish() // eski sayfayı kapattık
        }


    }

}