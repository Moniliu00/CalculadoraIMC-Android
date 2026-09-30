package com.moniliu.calculadoraimc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Slide
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //height

    lateinit var heightTextView: TextView
    lateinit var heightSlide: Slider

    //weight
    lateinit var weightTextView: TextView
    lateinit var minusWeightButton: Button
    lateinit var plusWeightButton: Button

// Result & Buttons

    lateinit var calculateButton: Button
    lateinit var resultTextView: TextView

    // BMI values
    var height = 170.0

    var weight = 70.0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main) // le digo al activity cual es su layout

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscar componenetes en la vista

        findViews()


        // Dar funcionalidad a los componentes
        initViews()


    }

    fun findViews () {
            // height
        heightTextView = findViewById(R.id.heightTextView)
        heightSlide = findViewById(R.id.heihtSlider)

        //weight
            weightTextView = findViewById(R.id.weightTextView)
            minusWeightButton = findViewById(R.id.minusWeightButton)
        plusWeightButton = findViewById(R.id.plusWeightButton)


            //Result & buttons

            calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

            }

    fun initViews() {
        //height
        heightSlide.addOnChangeListener { slider, value, fromUser ->
            height = value.toDouble()
            heightTextView.text = height.toInt().toString()
        }

        //weight
        minusWeightButton.setOnClickListener {
            weight --
            weightTextView.text = weight.toInt().toString()

        }
        plusWeightButton.setOnClickListener {
            weight ++
            weightTextView.text = weight.toInt().toString()
        }


        //Result & buttons

      calculateButton.setOnClickListener {
          calculateBMI()
      }

    }
    fun calculateBMI(){
        val heightInMeters = height / 100


        val result = weight / heightInMeters.pow(n = 2)

        resultTextView.text = result.toString()

    }


}