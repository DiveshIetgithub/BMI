package com.example.bmi_calculator

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
                if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED)
                {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:7355942912"))
                    startActivity(intent)
                }
                else
                {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),1001)
                }

            }

            R.id.btn_Action_Email->
            {
                val intent =Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:kdivesh556@gmail.com"))
                startActivity(intent)
            }

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode==7518)
        {
            if (grantResults.isNotEmpty() && permissions[0].equals(PackageManager.PERMISSION_GRANTED))
            {

            }
            else
            {
                Toast.makeText(this, "please give permission", Toast.LENGTH_SHORT).show()
            }
        }

    }

}