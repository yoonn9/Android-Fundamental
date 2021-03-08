package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var yourGoodie: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sayHello: ImageButton = findViewById(R.id.say_hello)
        sayHello.setOnClickListener(this)

        val instantGoodie: ImageButton = findViewById(R.id.instant_goodie)
        instantGoodie.setOnClickListener(this)

        val chooseGoodie: ImageButton = findViewById(R.id.choose_goodie)
        chooseGoodie.setOnClickListener(this)

        val moreGoodie: ImageButton = findViewById(R.id.more_unique)
        moreGoodie.setOnClickListener(this)

        val callLoved: ImageButton = findViewById(R.id.call)
        callLoved.setOnClickListener(this)

        yourGoodie = findViewById(R.id.your_goodie)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.say_hello -> {
                val moveActivity = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveActivity)
            }

            R.id.instant_goodie -> {
                val moveDataActivity = Intent(this@MainActivity, MoveDataActivity::class.java)
                moveDataActivity.putExtra(MoveDataActivity.EXTRA_LINE_1, "You have")
                moveDataActivity.putExtra(MoveDataActivity.EXTRA_LINE_2, "To be odd to be number")
                moveDataActivity.putExtra(MoveDataActivity.EXTRA_LINE_3, 1)
                startActivity(moveDataActivity)
            }

            R.id.choose_goodie -> {
                val moveResultActivity = Intent(this@MainActivity, MoveResultActivity::class.java)
                startActivityForResult(moveResultActivity, REQUEST_CODE)
            }

            R.id.more_unique -> {
                val unique = Author(
                        "Have the courage to follow your heart and intuition",
                        "Steve Jobs",
                        1955,
                        2011
                )

                val moveObjectActivity = Intent(this@MainActivity, MoveObjectActivity::class.java)
                moveObjectActivity.putExtra(MoveObjectActivity.EXTRA_QUOTE, unique)
                startActivity(moveObjectActivity)
            }

            R.id.call -> {
                val call = "1111"
                val callActivity = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$call"))
                startActivity(callActivity)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if(resultCode == MoveResultActivity.RESULT_CODE){
                val value = data?.getStringExtra(MoveResultActivity.EXTRA_CHOICE)
                yourGoodie.text = "$value"
            }
        }
    }
}