package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        bottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment :Fragment? = null
        when(item.itemId){
            R.id.homeMenu -> {
                fragment = HomeFragment()
            }
            R.id.music -> {
                fragment = MusicFragment()
            }
        }
        return loadFragment(fragment!!)
    }
/*
    override fun onBackPressed() {
        if(bottomNavigationView.selectedItemId==R.id.homeMenu) {
            super.onBackPressed()
            finish()
        }else{
            bottomNavigationView.selectedItemId=R.id.homeMenu
        }
    }*/

    fun loadFragment(fragment: Fragment): Boolean {
        if(fragment!=null){
            val mFragmentManager = supportFragmentManager
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frameLayoutMain, fragment)
                .addToBackStack(null)
                .commit()
        }
        return true
    }
}