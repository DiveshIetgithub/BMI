package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bmi_calculator.databinding.ActivitySecondMainBinding

class SecondMainActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getFloatExtra("bmi", 0f)

        binding.bmiTextView.text =bmi.toString()

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
            R.id.item_01 -> Toast.makeText(this,"About Selected", Toast.LENGTH_SHORT).show()
            R.id.item_02 -> Toast.makeText(this,"Settings Selected", Toast.LENGTH_SHORT).show()
            R.id.item_03-> Toast.makeText(this,"Exit Selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}