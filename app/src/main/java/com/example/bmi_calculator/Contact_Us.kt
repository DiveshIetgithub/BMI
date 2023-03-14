package com.example.bmi_calculator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmi_calculator.databinding.ActivityContactUsBinding

class Contact_Us : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityContactUsBinding
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActionView.setOnClickListener(this)
        binding.btnActionDial.setOnClickListener(this)
        binding.btnActionCall.setOnClickListener(this)
        binding.btnActionEmail.setOnClickListener(this)
    }

    override fun onClick(view:View?) {

        when(view!!.id)
        {
            R.id.btn_Action_View->
            {
               val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/healthyweight/assessing/bmi/index.html#:~:text=Body%20Mass%20Index%20(BMI)%20is,or%20health%20of%20an%20individual."))
                startActivity(intent)
            }
            R.id.btn_Action_Dial->
            {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:7518841932"))
                startActivity(intent)
            }
            R.id.btn_Action_Call->
            {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:7518841932"))
                startActivity(intent)
            }
            R.id.btn_Action_Email->
            {
                val intent =Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:kdivesh556@gmail.com"))
                startActivity(intent)
            }

        }

    }
}