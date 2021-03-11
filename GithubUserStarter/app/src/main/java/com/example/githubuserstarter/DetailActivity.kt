package com.example.githubuserstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object{
        const val DETAIL_USER = "detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataUser = intent.getParcelableExtra<User>(DETAIL_USER) as User

        val set_username: TextView = findViewById(R.id.tv_username_detail)
        val set_name: TextView = findViewById(R.id.tv_name_detail)
        val set_location: TextView = findViewById(R.id.tv_location_detail)
        val set_repository: TextView = findViewById(R.id.tv_repository_detail)
        val set_company: TextView = findViewById(R.id.tv_company_detail)
        val set_followers: TextView = findViewById(R.id.tv_followers_detail)
        val set_following: TextView = findViewById(R.id.tv_following_detail)
        val set_avatar: ImageView = findViewById(R.id.iv_img_detail)

        set_username.text = getString(R.string.usernameSet, dataUser.username)
        set_name.text = dataUser.name
        set_location.text = getString(R.string.locationSet, dataUser.location)
        set_repository.text = getString(R.string.repositorySet, dataUser.repository)
        set_company.text = getString(R.string.companySet, dataUser.company)
        set_followers.text = getString(R.string.followersSet, dataUser.followers)
        set_following.text = getString(R.string.followingSet, dataUser.following)
        set_avatar.setImageResource(dataUser.avatar)
    }
}