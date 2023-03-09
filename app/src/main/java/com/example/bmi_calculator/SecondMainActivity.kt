package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bmi_calculator.databinding.ActivitySecondMainBinding
import kotlin.system.exitProcess

class SecondMainActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondMainBinding


    override fun onBackPressed() =Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getFloatExtra("bmi", 0f)

        binding.bmiTextView.setText(String.format("%.2f",bmi))

       // binding.bmiTextView.text =bmi.toString()

        val bmiCategory = getBMICategory(bmi)
        binding.categoryTextView.text = bmiCategory
    }

    private fun getBMICategory(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25 -> "Normal weight"
            bmi < 30 -> "Overweight"
            else -> "Obese"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when (item.itemId){
            R.id.item_01 ->
            {
                var intent = Intent(this,AboutBMI::class.java)
                startActivity(intent)
            }
            R.id.item_02 ->
            {
                var intent = Intent(this, BmiChart::class.java)
                startActivity(intent)

            }

            R.id.item_03-> {
                finish()
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}