package com.manny.espressoui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.manny.espressoui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNextActivity.setOnClickListener {
            val intent = Intent(this,SecondaryActivity::class.java)
            startActivity(intent)
        }






//        button_next_activity.setOnClickListener {
//            val intent = Intent(this, SecondaryActivity::class.java)
//            startActivity(intent)
//        }
    }
}