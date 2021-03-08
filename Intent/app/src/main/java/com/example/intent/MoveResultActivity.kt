package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rg_choice: RadioGroup
    private lateinit var btn_choose : Button

    companion object{
        const val EXTRA_CHOICE = "extra_choice"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_result)

        rg_choice = findViewById(R.id.rg_main)
        btn_choose = findViewById(R.id.button_main)
        btn_choose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_main){
            var value = ""
            when(rg_choice.checkedRadioButtonId) {
                R.id.glory -> value = getResources().getString(R.string.gloryOption)
                R.id.start -> value = getResources().getString(R.string.lifeOption)
                R.id.time -> value = getResources().getString(R.string.timeOption)
                R.id.success -> value = getResources().getString(R.string.successOption)
            }

            val result = Intent()
            result.putExtra(EXTRA_CHOICE, value)
            setResult(RESULT_CODE, result)
            finish()
        }
    }
}
