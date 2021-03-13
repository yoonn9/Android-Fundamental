package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.DisneyAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Disney
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private val list = ArrayList<Disney>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.rvMain.setHasFixedSize(true)
        list.addAll(getListDisney())
        showRecyclerList()
    }

    fun getListDisney(): ArrayList<Disney> {
        val dataDisney = resources.getStringArray(R.array.data_disney)
        val dataQuote = resources.getStringArray(R.array.data_quote)
        val dataImage = resources.obtainTypedArray(R.array.data_image)

        val listDisney = ArrayList<Disney>()
        for (position in dataDisney.indices) {
            val disney = Disney(
                dataImage.getResourceId(position, -1),
                dataQuote[position],
                    dataDisney[position]
            )
            listDisney.add(disney)
        }
        return listDisney
    }

    private fun showRecyclerList() {
        activityMainBinding.rvMain.layoutManager = LinearLayoutManager(this)
        val disneyAdapter = DisneyAdapter(list)
        activityMainBinding.rvMain.adapter = disneyAdapter

        disneyAdapter.setOnItemClickCallback(object : DisneyAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Disney) {
                showSelectedDisney(data)
            }
        })
    }

    private fun showSelectedDisney(disneyEntity: Disney) {
        Toast.makeText(this, "${disneyEntity.title}", Toast.LENGTH_SHORT).show()
    }

}