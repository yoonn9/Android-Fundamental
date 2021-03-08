package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveDataActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_LINE_1 = "extra_line_1"
        const val EXTRA_LINE_2 = "extra_line_2"
        const val EXTRA_LINE_3 = "extra_line_3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        val line1: TextView = findViewById(R.id.line1)
        val line2: TextView = findViewById(R.id.line2)
        val line3: TextView = findViewById(R.id.line3)


        line1.text = intent.getStringExtra(EXTRA_LINE_1)
        line2.text = intent.getStringExtra(EXTRA_LINE_2)
        val num = intent.getIntExtra(EXTRA_LINE_3, 0)
        line3.text = "$num"
    }
}