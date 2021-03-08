package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MoveObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_QUOTE = "extra_quote"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        val goodie:TextView = findViewById(R.id.goodieObject)
        val name:TextView = findViewById(R.id.author)
        val time:TextView = findViewById(R.id.period)

        val author = intent.getParcelableExtra<Author>(EXTRA_QUOTE) as Author
        goodie.text = author.quote
        name.text = author.name
        val period = author.period
        val periodEnd = author.periodEnd
        time.text = "$period - $periodEnd"
    }
}