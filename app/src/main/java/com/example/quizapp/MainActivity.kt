package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnStart: Button = findViewById(R.id.btn_start)
        val edtName: EditText = findViewById(R.id.edt_name)
        btnStart.setOnClickListener {
            if (edtName.text.trim().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, QuizQuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, edtName.text.toString())
            startActivity(intent)
            finish()
        }


    }
}