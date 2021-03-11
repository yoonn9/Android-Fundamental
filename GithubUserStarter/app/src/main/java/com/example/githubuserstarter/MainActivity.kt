package com.example.githubuserstarter

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataImage: TypedArray
    private var listOfUser = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: ListView = findViewById(R.id.listMain)

        adapter = UserAdapter(this)
        list.adapter = adapter

        resource()
        addItem()

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val user = User(
                    listOfUser[position].username,
                    listOfUser[position].name,
                    listOfUser[position].location,
                    listOfUser[position].repository,
                    listOfUser[position].company,
                    listOfUser[position].followers,
                    listOfUser[position].following,
                    listOfUser[position].avatar,
            )

            val moveIntentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
            moveIntentToDetail.putExtra(DetailActivity.DETAIL_USER, user)
            startActivity(moveIntentToDetail)
        }
    }

    private fun resource() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataImage = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataImage.getResourceId(position, -1)
            )
            listOfUser.add(user)
        }
        adapter.userGithub = listOfUser
    }
}