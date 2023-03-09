package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bmi_calculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateBMI()

        }
    }

    private fun calculateBMI() {
        val weight = binding.weight.editText!!.text.toString().toFloatOrNull()
        val height = binding.height.editText!!.text.toString().toFloatOrNull()

        if (weight == null || height == null) {
            Toast.makeText(this, "Please enter weight and height", Toast.LENGTH_SHORT).show()
            return
        }

        val bmi = weight / (height/100).pow(2)

        val intent = Intent(this, SecondMainActivity::class.java)
        intent.putExtra( "bmi",bmi)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when (item.itemId){
            R.id.item_01 -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
            R.id.item_02 -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.item_03-> Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}