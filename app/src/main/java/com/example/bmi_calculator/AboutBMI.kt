package com.example.bmi_calculator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmi_calculator.databinding.ActivityAboutBmiBinding

class AboutBMI : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityAboutBmiBinding
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAboutBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AboutBMI.setOnClickListener(this)

    }

    override fun onClick(view:View?) {
        when (view!!.id) {
            R.id.About_BMI -> {
                val intent=Intent(
                    Intent.ACTION_SEARCH,Uri.parse("https://www.news-medical.net/health/What-is-Body-Mass-Index-(BMI).aspx")
                )
                startActivity(intent)
            }
        }
    }
}