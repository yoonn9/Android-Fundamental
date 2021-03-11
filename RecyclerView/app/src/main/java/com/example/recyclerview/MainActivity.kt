package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.ListCharAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Character
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.setHasFixedSize(true)

        list.addAll(getListCharacters())
        showRecyclerList()
    }

    fun getListCharacters(): ArrayList<Character> {
        val dataCharacter = resources.getStringArray(R.array.data_character)
        val dataQuote = resources.getStringArray(R.array.data_quote)
        val dataImage = resources.obtainTypedArray(R.array.data_image)

        val listChar = ArrayList<Character>()
        for (position in dataCharacter.indices) {
            val char = Character(
                dataImage.getResourceId(position, -1),
                dataQuote[position],
                dataCharacter[position]
            )
            listChar.add(char)
        }
        return listChar
    }

    private fun showRecyclerList() {
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        binding.rvMain.adapter = listCharAdapter

        listCharAdapter.setOnItemClickCallback(object : ListCharAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Character) {
                showSelectedChar(data)
            }
        })
    }

    private fun showSelectedChar(char: Character) {
        Toast.makeText(this, "${char.title}", Toast.LENGTH_SHORT).show()
    }

}