package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var heightMain: EditText
    private lateinit var weightMain: EditText
    private lateinit var bmiMain: Button
    private lateinit var resultMain: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightMain = findViewById(R.id.height_main)
        weightMain = findViewById(R.id.weight_main)
        bmiMain = findViewById(R.id.btn_bmi_main)
        resultMain = findViewById(R.id.result_main)

        bmiMain.setOnClickListener(this)

        if(savedInstanceState!=null){
            val result = savedInstanceState.getString(STATE_RESULT)
            resultMain.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, resultMain.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_bmi_main) {
            val heightInput = heightMain.text.toString().trim()
            val weightInput = weightMain.text.toString().trim()

            var isEmpty = false

            when {
                heightInput.isEmpty() -> {
                    isEmpty = true
                    heightMain.error = "Field can't be empty"
                }
                weightInput.isEmpty() -> {
                    isEmpty = true
                    weightMain.error = "Field can't be empty"
                }
            }

            var bmiResult = 0.0
            if (!isEmpty) {
                val base = heightInput.toDouble() /100.0
                val exponent = 2
                bmiResult = weightInput.toDouble() / Math.pow( base, exponent.toDouble())

            val category:String?
            if(bmiResult<18.5) category = "underweight"
            else if(bmiResult>=18.5 && bmiResult<=24.9) category = "normal weight"
            else if(bmiResult>=25 && bmiResult<=29.9) category = "overweight"
            else category = "obesity"

            val roundedBMI = "%.2f".format(bmiResult)
            resultMain.text = "Your Body Mass Index is $roundedBMI. \nThis is considered $category"
            }
        }
    }
}