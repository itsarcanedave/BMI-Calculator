package com.example.weightdiary_lifeinformationsystem

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_diet.*

class Diet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet)
        diet()
        val buttonBack = findViewById<ImageButton>(R.id.bmiBack2)
        buttonBack.setOnClickListener {

            val intent = Intent(this, BMI::class.java)
            startActivity(intent)

        }
    }

    fun diet () {
        var BMI = intent.getStringExtra("BMI")
        var gender = intent.getStringExtra("Gender")
        var age = intent.getIntExtra("Age", 0)
        val energy = findViewById<TextView>(R.id.energy)
        val fat = findViewById<TextView>(R.id.fat)
        val protein = findViewById<TextView>(R.id.protein)
        val carbs = findViewById<TextView>(R.id.carbs)
        val water = findViewById<TextView>(R.id.water)
        //UpperLeft
        val rice = findViewById<ImageView>(R.id.rice)
        val bihun = findViewById<ImageView>(R.id.bihun)
        val noodles = findViewById<ImageView>(R.id.noodle)
        //UpperRight
        val tempe = findViewById<ImageView>(R.id.tempe)
        val corn = findViewById<ImageView>(R.id.corn)
        val toast = findViewById<ImageView>(R.id.toast)
        val tofu = findViewById<ImageView>(R.id.tofu)
        val potato = findViewById<ImageView>(R.id.potato)
        //LowerRight
        val veggies = findViewById<ImageView>(R.id.veggies)
        val eggBoiled = findViewById<ImageView>(R.id.eggBoiled)
        val eggScrambled = findViewById<ImageView>(R.id.eggScrambled)
        val eggFried = findViewById<ImageView>(R.id.eggFried)
        //LowerLeft
        val milk = findViewById<ImageView>(R.id.milk)
        val orange = findViewById<ImageView>(R.id.orange)
        val papaya = findViewById<ImageView>(R.id.papaya)
        val melon = findViewById<ImageView>(R.id.melon)
        val mango = findViewById<ImageView>(R.id.mango)
        val banana = findViewById<ImageView>(R.id.banana)
        val apple = findViewById<ImageView>(R.id.apple)


            if (age <= 3) {
            energy.text = 1350.toString()
            protein.text = 20.toString()
            fat.text = 45.toString()
            carbs.text = 215.toString()
            water.text = 1150.toString()
            rice.visibility = View.VISIBLE
            tofu.visibility = View.VISIBLE
            veggies.visibility = View.VISIBLE
            milk.visibility = View.VISIBLE
            }
        else if (age <= 6) {
            energy.text = 1400.toString()
            protein.text = 25.toString()
            fat.text = 50.toString()
            carbs.text = 220.toString()
            water.text = 1450.toString()
            rice.visibility = View.VISIBLE
            tofu.visibility = View.VISIBLE
            veggies.visibility = View.VISIBLE
            milk.visibility = View.VISIBLE
        }
        else if (age <= 9) {
            energy.text = 1650.toString()
            protein.text = 40.toString()
            fat.text = 55.toString()
            carbs.text = 250.toString()
            water.text = 1650.toString()
            rice.visibility = View.VISIBLE
            toast.visibility = View.VISIBLE
            veggies.visibility = View.VISIBLE
            milk.visibility = View.VISIBLE
        }
        else if (age <= 12 && gender == "Male") {
            energy.text = 2000.toString()
            protein.text = 50.toString()
            fat.text = 65.toString()
            carbs.text = 300.toString()
            water.text = 1850.toString()
                rice.visibility = View.VISIBLE
                toast.visibility = View.VISIBLE
                eggScrambled.visibility = View.VISIBLE
                milk.visibility = View.VISIBLE
        }
        else if (age <= 15 && gender == "Male") {
            energy.text = 2400.toString()
            protein.text = 70.toString()
            fat.text = 80.toString()
            carbs.text = 350.toString()
            water.text = 2100.toString()
                rice.visibility = View.VISIBLE
                toast.visibility = View.VISIBLE
                eggScrambled.visibility = View.VISIBLE
                milk.visibility = View.VISIBLE
        }
        else if (age <= 18 && gender == "Male") {
            energy.text = 2650.toString()
            protein.text = 75.toString()
            fat.text = 85.toString()
            carbs.text = 400.toString()
            water.text = 2300.toString()
                rice.visibility = View.VISIBLE
                corn.visibility = View.VISIBLE
                eggFried.visibility = View.VISIBLE
                apple.visibility = View.VISIBLE
        }
        else if (age <= 29 && gender == "Male") {
            energy.text = 2650.toString()
            protein.text = 65.toString()
            fat.text = 75.toString()
            carbs.text = 430.toString()
            water.text = 2500.toString()
                bihun.visibility = View.VISIBLE
                corn.visibility = View.VISIBLE
                eggFried.visibility = View.VISIBLE
                apple.visibility = View.VISIBLE
        }
        else if (age <= 49 && gender == "Male") {
            energy.text = 2550.toString()
            protein.text = 65.toString()
            fat.text = 70.toString()
            carbs.text = 415.toString()
            water.text = 2500.toString()
                bihun.visibility = View.VISIBLE
                tempe.visibility = View.VISIBLE
                eggBoiled.visibility = View.VISIBLE
                apple.visibility = View.VISIBLE
        }
        else if (age <= 64 && gender == "Male") {
            energy.text = 2150.toString()
            protein.text = 65.toString()
            fat.text = 60.toString()
            carbs.text = 340.toString()
            water.text = 2500.toString()
                noodles.visibility = View.VISIBLE
                potato.visibility = View.VISIBLE
                eggBoiled.visibility = View.VISIBLE
                orange.visibility = View.VISIBLE
        }
        else if (age <= 80 && gender == "Male") {
            energy.text = 1800.toString()
            protein.text = 64.toString()
            fat.text = 50.toString()
            carbs.text = 275.toString()
            water.text = 1800.toString()
                noodles.visibility = View.VISIBLE
                potato.visibility = View.VISIBLE
                veggies.visibility = View.VISIBLE
                orange.visibility = View.VISIBLE
        }
        else if (age > 80 && gender == "Male") {
            energy.text = 1600.toString()
            protein.text = 64.toString()
            fat.text = 45.toString()
            carbs.text = 235.toString()
            water.text = 1600.toString()
                noodles.visibility = View.VISIBLE
                potato.visibility = View.VISIBLE
                veggies.visibility = View.VISIBLE
                orange.visibility = View.VISIBLE

        }
        else if (age <= 12 && gender == "Female") {
            energy.text = 1900.toString()
            protein.text = 55.toString()
            fat.text = 65.toString()
            carbs.text = 280.toString()
            water.text = 1850.toString()
                rice.visibility = View.VISIBLE
                toast.visibility = View.VISIBLE
                eggScrambled.visibility = View.VISIBLE
                banana.visibility = View.VISIBLE
        }
        else if (age <= 15 && gender == "Female") {
            energy.text = 2050.toString()
            protein.text = 65.toString()
            fat.text = 70.toString()
            carbs.text = 300.toString()
            water.text = 2100.toString()
                rice.visibility = View.VISIBLE
                toast.visibility = View.VISIBLE
                eggScrambled.visibility = View.VISIBLE
                banana.visibility = View.VISIBLE
        }
        else if (age <= 18 && gender == "Female") {
            energy.text = 2100.toString()
            protein.text = 65.toString()
            fat.text = 70.toString()
            carbs.text = 300.toString()
            water.text = 2100.toString()
                rice.visibility = View.VISIBLE
                corn.visibility = View.VISIBLE
                eggFried.visibility = View.VISIBLE
                banana.visibility = View.VISIBLE
        }
        else if (age <= 29 && gender == "Female") {
            energy.text = 2250.toString()
            protein.text = 60.toString()
            fat.text = 65.toString()
            carbs.text = 360.toString()
            water.text = 2350.toString()
                bihun.visibility = View.VISIBLE
                corn.visibility = View.VISIBLE
                eggFried.visibility = View.VISIBLE
                mango.visibility = View.VISIBLE
        }
        else if (age <= 49 && gender == "Female") {
            energy.text = 2150.toString()
            protein.text = 60.toString()
            fat.text = 60.toString()
            carbs.text = 340.toString()
            water.text = 2350.toString()
                bihun.visibility = View.VISIBLE
                tempe.visibility = View.VISIBLE
                eggBoiled.visibility = View.VISIBLE
                mango.visibility = View.VISIBLE
        }
        else if (age <= 64 && gender == "Female") {
            energy.text = 1800.toString()
            protein.text = 60.toString()
            fat.text = 50.toString()
            carbs.text = 280.toString()
            water.text = 2350.toString()
                noodles.visibility = View.VISIBLE
                potato.visibility = View.VISIBLE
                eggBoiled.visibility = View.VISIBLE
                melon.visibility = View.VISIBLE
        }
        else if (age <= 80 && gender == "Female") {
            energy.text = 1550.toString()
            protein.text = 58.toString()
            fat.text = 45.toString()
            carbs.text = 230.toString()
            water.text = 1550.toString()
                noodles.visibility = View.VISIBLE
                potato.visibility = View.VISIBLE
                veggies.visibility = View.VISIBLE
                papaya.visibility = View.VISIBLE
        }
        else if (age > 80 && gender == "Female") {
            energy.text = 1400.toString()
            protein.text = 58.toString()
            fat.text = 40.toString()
            carbs.text = 200.toString()
            water.text = 1400.toString()
                noodles.visibility = View.VISIBLE
                potato.visibility = View.VISIBLE
                veggies.visibility = View.VISIBLE
                papaya.visibility = View.VISIBLE
        }

    }
}