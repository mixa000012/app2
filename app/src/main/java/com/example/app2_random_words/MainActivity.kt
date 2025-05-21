package com.example.app2_random_words

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var dig1: Int = Random.nextInt(0,10)
        val button: Button = findViewById(R.id.button)
        val editView: EditText = findViewById(R.id.editTextText)
        val textView: TextView = findViewById(R.id.textView)
        button.setOnClickListener {
            try {
                var dig = Integer.valueOf(editView.getText().toString());
                if (dig > dig1) {
                    textView.text = "Меньше"
                } else if (dig == dig1) {
                    textView.text = "Вы угадали!"
                } else {
                    textView.text = "Больше"
                }
            }
            catch (e: NumberFormatException){
                textView.text = "Введите число"
            }

        }
    }



}