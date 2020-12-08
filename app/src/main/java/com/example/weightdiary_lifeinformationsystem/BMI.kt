package com.example.weightdiary_lifeinformationsystem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.lang.NumberFormatException

class BMI : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_bmi)



            val buttonMale = findViewById<ImageButton>(R.id.genderMale)
            val buttonFemale = findViewById<ImageButton>(R.id.genderFemale)
            buttonMale.setOnClickListener {
                buttonMale.visibility = View.INVISIBLE
                buttonFemale.visibility = View.VISIBLE
            }
            buttonFemale.setOnClickListener {
                buttonFemale.visibility = View.INVISIBLE
                buttonMale.visibility = View.VISIBLE
            }

            val buttonDietary = findViewById<ImageButton>(R.id.dietary)
            val buttonClickHere = findViewById<ImageButton>(R.id.clickHere)
                buttonClickHere.setOnClickListener {
                    countBMI()
                    buttonClickHere.visibility = View.GONE
                    buttonDietary.visibility = View.VISIBLE
                }
            val buttonReset = findViewById<ImageButton>(R.id.reset)
            buttonReset.setOnClickListener {
                finish()
                overridePendingTransition(0, 0);
                val intent = Intent(this, BMI::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0);
            }
            val buttonBack = findViewById<ImageButton>(R.id.bmiBack)
            buttonBack.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }


        }
    @SuppressLint("SetTextI18n")
    fun countBMI () {
        var heightEdit = findViewById<EditText>(R.id.height).text
        var finalHeight = heightEdit.toString()
        var weightEdit = findViewById<EditText>(R.id.weight).text
        var finalWeight = weightEdit
        var ageEdit = findViewById<EditText>(R.id.age).text
        var finalAge = ageEdit
        val bmiText = findViewById<TextView>(R.id.bmiText)
        val normalWeightXText = findViewById<TextView>(R.id.normalWeightX)
        val normalWeightYText = findViewById<TextView>(R.id.normalWeightY)
        var BMIRaw = (finalWeight.toString()
            .toInt() / ((finalHeight.toDouble() / 100) * (finalHeight.toDouble() / 100)))
        var BMI = String.format("%.1f", BMIRaw)
        bmiText.text = BMI
        try {


//            Toast.makeText(this@BMI, BMI.toString(), Toast.LENGTH_LONG).show()
            var verySeverely = findViewById<ImageView>(R.id.verySeverly)
            var severelyUnder = findViewById<ImageView>(R.id.severlyUnder)
            var underweight = findViewById<ImageView>(R.id.underweight)
            var normal = findViewById<ImageView>(R.id.normal)
            var overweight = findViewById<ImageView>(R.id.overweight)
            var obese_one = findViewById<ImageView>(R.id.obese_one)
            var obese_two = findViewById<ImageView>(R.id.obese_two)
            var obese_three = findViewById<ImageView>(R.id.obese_three)
            var verySeverelyArrow = findViewById<ImageView>(R.id.veryseverelyunderarrow)
            var severelyUnderArrow  = findViewById<ImageView>(R.id.severelyunderarrow)
            var underweightArrow  = findViewById<ImageView>(R.id.underweightarrow)
            var normalArrow  = findViewById<ImageView>(R.id.normalarrow)
            var overweightArrow  = findViewById<ImageView>(R.id.overweightarrow)
            var obese_oneArrow  = findViewById<ImageView>(R.id.obeseonearrow)
            var obese_twoArrow  = findViewById<ImageView>(R.id.obesetwoarrow)
            var obese_threeArrow  = findViewById<ImageView>(R.id.obesethreearrow)
            var difference = findViewById<TextView>(R.id.difference)
            if (BMI.toDouble() < 16) {
                verySeverely.visibility = View.VISIBLE
                verySeverelyArrow.visibility = View.VISIBLE

                var normal = (18.5 - BMI.toDouble())
                difference.text = "-" + (String.format("%.1f", normal)).toString()
            } else if (BMI.toDouble() < 16.9) {
                severelyUnder.visibility = View.VISIBLE
                severelyUnderArrow.visibility = View.VISIBLE

                var normal = (18.5 - BMI.toDouble())
                difference.text = "-" + (String.format("%.1f", normal)).toString()
            } else if (BMI.toDouble() < 18.5) {
                underweight.visibility = View.VISIBLE
                underweightArrow.visibility = View.VISIBLE

                var normal = (18.5 - BMI.toDouble())
                difference.text = "-" + (String.format("%.1f", normal)).toString()
            } else if (BMI.toDouble() < 25) {
                normal.visibility = View.VISIBLE
                normalArrow.visibility = View.VISIBLE

                difference.text = "OK!"
            } else if (BMI.toDouble() < 30) {
                overweight.visibility = View.VISIBLE
                overweightArrow.visibility = View.VISIBLE

                var normal = (BMI.toDouble() - 25)
                difference.text = "+" + (String.format("%.1f", normal)).toString()
            } else if (BMI.toDouble() < 35) {
                obese_one.visibility = View.VISIBLE
                obese_oneArrow.visibility = View.VISIBLE

                var normal = (BMI.toDouble() - 25)
                difference.text = "+" + (String.format("%.1f", normal)).toString()

            } else if (BMI.toDouble() < 40) {
                obese_two.visibility = View.VISIBLE
                obese_twoArrow.visibility = View.VISIBLE

                var normal = (BMI.toDouble() - 25)
                difference.text = "+" + (String.format("%.1f", normal)).toString()

            } else if (BMI.toDouble() > 40) {
                obese_three.visibility = View.VISIBLE
                obese_threeArrow.visibility = View.VISIBLE


                var normal = (BMI.toDouble() - 25)
                difference.text = "+" + (String.format("%.1f", normal)).toString()
            }
        }
        catch (e: NumberFormatException){
            Toast.makeText(this@BMI, "Invalid input!", Toast.LENGTH_LONG).show()
        }
        val rawWeightX = (((finalHeight.toDouble() / 100) * (finalHeight.toDouble() / 100)) * 18.5)
        var normalWeightX = (String.format("%.1f", rawWeightX)).toString()
        val rawWeightY = (((finalHeight.toDouble() / 100) * (finalHeight.toDouble() / 100)) * 24.9)
        var normalWeightY = (String.format("%.1f", rawWeightY)).toString()
        normalWeightXText.text = normalWeightX
        normalWeightYText.text = normalWeightY
        val BMIData = BMI
        val WeightData = (finalWeight.toString().toInt())
        val Date = System.currentTimeMillis()
        val inputData = WeightHistory(Date,WeightData,BMIData)
        val database = BMIDatabase.getInstance(applicationContext)
        database.DatabaseDao.insert(inputData)

        var gender: String = "Default"
        val buttonMale = findViewById<ImageButton>(R.id.genderMale)
        val buttonFemale = findViewById<ImageButton>(R.id.genderFemale)
        if (buttonMale.visibility == View.VISIBLE) {
            gender = "Male"
        } else if (buttonFemale.visibility == View.VISIBLE) {
            gender = "Female"
        }
        var ageText = findViewById<TextView>(R.id.age).text.toString()
        var age = Integer.parseInt(ageText)
        val buttonDietary = findViewById<ImageButton>(R.id.dietary)




        buttonDietary.setOnClickListener {

            val intent = Intent(this, Diet::class.java)
            intent.putExtra("BMI", BMI)
            intent.putExtra("Gender", gender)
            intent.putExtra("Age", age)

            startActivity(intent)
        }
    }




}
