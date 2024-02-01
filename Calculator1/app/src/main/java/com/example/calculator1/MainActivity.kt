package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plus = findViewById<Button>(R.id.buttonAdd)
        val minus = findViewById<Button>(R.id.buttonSubstract)
        val multiply = findViewById<Button>(R.id.buttonMultiply)
        val divide = findViewById<Button>(R.id.buttonDivide)
        val input1=findViewById<TextInputEditText>(R.id.etField1)
        val input2=findViewById<TextInputEditText>(R.id.etField2)
        val result=findViewById<TextView>(R.id.calResult)

        plus.setOnClickListener {
            val firstInput=input1.text.toString().toInt()
            val secondInput=input2.text.toString().toInt()

            result.text= (firstInput+secondInput).toString()
        }
        minus.setOnClickListener {
            val firstInput=input1.text.toString().toInt()
            val secondInput=input2.text.toString().toInt()

            result.text= (firstInput-secondInput).toString()
        }
        multiply.setOnClickListener {
            val firstInput=input1.text.toString().toInt()
            val secondInput=input2.text.toString().toInt()

            result.text= (firstInput*secondInput).toString()
        }
        divide.setOnClickListener {
            val firstInput=input1.text.toString().toInt()
            val secondInput=input2.text.toString().toInt()

            result.text= (firstInput/secondInput).toString()
        }
    }
}