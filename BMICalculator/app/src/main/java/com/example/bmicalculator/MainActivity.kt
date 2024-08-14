package com.example.bmicalculator

import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText=findViewById<EditText>(R.id.etWeight)
        val heightText=findViewById<EditText>(R.id.etHeight)
        val calcButton=findViewById<Button>(R.id.btnCalculate)

        calcButton.setOnClickListener {
            val weight=weightText.text.toString()
            val height=heightText.text.toString()

            if (validateInput(weight,height)) {

                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                val bmi2Digits = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2Digits)
            }
        }


    }

    private fun validateInput(weight:String?, height:String?):Boolean {
        return when {
            weight.isNullOrBlank() -> {
                Toast.makeText(this,"Weight is empty",Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrBlank() -> {
                Toast.makeText(this,"Height is empty",Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                return true
            }
        }
    }

    private fun displayResult(bmi:Float){
        val resultIndex=findViewById<TextView>(R.id.tvIndex)
        val resultDescription=findViewById<TextView>(R.id.tvResult)
        val info=findViewById<TextView>(R.id.tvInfo)

        resultIndex.text=bmi.toString()
        info.text="(Normal range is 18.5 - 24.9)"

        var resultText=""
        var color=0

        when {
            bmi<18.50 -> {
                resultText="Underweight"
                color = ContextCompat.getColor(this, R.color.under_weight)
            }
            bmi in 18.50..24.99 -> {
                resultText="Healthy"
                color = ContextCompat.getColor(this, R.color.normal)
            }
            bmi in 25.00..29.99 -> {
                resultText="Overweight"
                color = ContextCompat.getColor(this, R.color.over_weight)
            }
            bmi>30.00 -> {
                resultText="Obese"
                color = ContextCompat.getColor(this, R.color.obese)
            }
        }
        resultDescription.setTextColor(color)
        resultDescription.text=resultText

    }
}