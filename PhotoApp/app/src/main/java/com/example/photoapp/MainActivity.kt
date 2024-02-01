package com.example.photoapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var image: ImageView

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val previous = findViewById<ImageButton>(R.id.btnPrevious)

        next.setOnClickListener {
            try {
                val idCurrentImageString = "pic$currentImage"
                val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)


                image = findViewById(idCurrentImageInt)
                image.alpha = 0f

                currentImage = (currentImage + 1+4) % 4
                val idImageToShowString = "pic$currentImage"
                val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)


                image = findViewById(idImageToShowInt)
                image.alpha = 1f
            } catch (e: Exception) {
                Log.e("MainActivity", "Error in next button click", e)
            }
        }

        previous.setOnClickListener {
            try {
                val idCurrentImageString = "pic$currentImage"
                val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)


                image = findViewById(idCurrentImageInt)
                image.alpha = 0f

                currentImage = (currentImage - 1+4) % 4
                val idImageToShowString = "pic$currentImage"
                val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)


                image = findViewById(idImageToShowInt)
                image.alpha = 1f
            } catch (e: Exception) {
                Log.e("MainActivity", "Error in previous button click", e)
            }
        }
    }
}
