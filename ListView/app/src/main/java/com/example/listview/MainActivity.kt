package com.example.listview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CharacterAdapter
    private lateinit var dataQuote: Array<String>
    private lateinit var dataTitle: Array<String>
    private lateinit var dataImage: TypedArray
    private var listOfChar = arrayListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ListView = findViewById(R.id.listMain)

        adapter = CharacterAdapter(this)
        list.adapter = adapter

        resource()
        addItem()

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, listOfChar[position].title, Toast.LENGTH_SHORT).show()
        }
    }

    private fun resource() {
        dataQuote = resources.getStringArray(R.array.data_quote)
        dataTitle = resources.getStringArray(R.array.data_character)
        dataImage = resources.obtainTypedArray(R.array.data_image)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val char = Character(
                    dataImage.getResourceId(position, -1),
                    dataQuote[position],
                    dataTitle[position]
            )
            listOfChar.add(char)
        }
        adapter.character = listOfChar
    }
}